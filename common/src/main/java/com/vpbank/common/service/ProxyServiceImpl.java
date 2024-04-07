package com.vpbank.common.service;

import com.vpbank.common.util.FormDataConverter;
import com.vpbank.common.util.ForwardBodyHandler;
import com.vpbank.common.util.Json;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import java.util.concurrent.CompletableFuture;

@Log4j2
@Service
public class ProxyServiceImpl implements ProxyService {
  private static final Set<String> DISALLOWED_HEADERS_SET;

  static {
    // A case insensitive TreeSet of strings.
    TreeSet<String> treeSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
    treeSet.addAll(Set.of("connection", "content-length",
            "date", "expect", "from", "host", "upgrade", "via", "warning"));
    DISALLOWED_HEADERS_SET = Collections.unmodifiableSet(treeSet);
  }

  private final HttpClient httpClient;
  private final int ignorePrefixLength;

  public ProxyServiceImpl(HttpClient httpClient,
                          @Value("${server.servlet.context-path}") String contextPath) {
    this.httpClient = httpClient;
    ignorePrefixLength = contextPath.length();
  }
  @Override
  public CompletableFuture<Void> forward(String baseUrl, HttpServletRequest request, HttpServletResponse response, Map<String, String> additionalHeaders) throws IOException {
    return doForward(baseUrl, request, response, newBodyPublisher(request), additionalHeaders);
  }
  @Override
  public CompletableFuture<Void> forwardWithParams(String baseUrl, HttpServletRequest request, HttpServletResponse response, String parameters, Map<String, String> additionalHeaders) throws IOException {
    return doForward(baseUrl, request, response, newBodyPublisher(request), additionalHeaders, parameters);
  }
  @Override
  public CompletableFuture<HttpResponse<byte[]>> forwardRequest(String baseUrl, HttpServletRequest request, Map<String, String> additionalHeaders) {
    HttpRequest.Builder forwardReq = getBuilder(baseUrl, request, newBodyPublisher(request), additionalHeaders);
    return httpClient.sendAsync(forwardReq.build(), HttpResponse.BodyHandlers.ofByteArray());
  }

  HttpRequest.BodyPublisher newBodyPublisher(HttpServletRequest request) {
    long contentLength = request.getContentLengthLong();
    if (contentLength == 0) {
      return HttpRequest.BodyPublishers.noBody();
    }
    var bodyPublisher = HttpRequest.BodyPublishers.ofInputStream(() -> {
      try {
        return request.getInputStream();
      } catch (IOException e) {
        log.error("can't get input stream of request to forward", e);
        return null;
      }
    });
    if (contentLength > 0) {
      bodyPublisher = HttpRequest.BodyPublishers.fromPublisher(bodyPublisher, contentLength);
    }
    return bodyPublisher;
  }
  @Override
  public CompletableFuture<Void> forwardWithFormData(String baseUrl, HttpServletRequest request, HttpServletResponse response, Map<String, Object> formData, Map<String, String> additionalHeaders) throws IOException {
    if (additionalHeaders != null) additionalHeaders.put("Content-Type", FormDataConverter.MULTI_FORM_DATA);
    else additionalHeaders = Collections.singletonMap("Content-Type", FormDataConverter.MULTI_FORM_DATA);
    return forwardWithBody(baseUrl, request, response, FormDataConverter.convert(formData), additionalHeaders);
  }
  @Override
  public CompletableFuture<Void> forwardWithBody(String baseUrl, HttpServletRequest request, HttpServletResponse response, Object body, Map<String, String> additionalHeaders) throws IOException {
    return forwardWithBody(baseUrl, request, response, Json.encode(body), additionalHeaders);
  }

  @Override
  public CompletableFuture<Void> forwardWithBody(String baseUrl, HttpServletRequest request, HttpServletResponse response, byte[] body, Map<String, String> additionalHeaders) throws IOException {
    var bodyPublisher = HttpRequest.BodyPublishers.ofByteArray(body);
    return doForward(baseUrl, request, response, bodyPublisher, additionalHeaders);
  }

  private CompletableFuture<Void> forwardWithBody(String baseUrl, HttpServletRequest request, HttpServletResponse response, List<byte[]> body, Map<String, String> additionalHeaders) throws IOException {
    var bodyPublisher = HttpRequest.BodyPublishers.ofByteArrays(body);
    return doForward(baseUrl, request, response, bodyPublisher, additionalHeaders);
  }
  private CompletableFuture<Void> doForward(String baseUrl, HttpServletRequest request, HttpServletResponse response, HttpRequest.BodyPublisher bodyPublisher,
                                            Map<String, String> additionalHeaders) throws IOException {
    HttpRequest.Builder forwardReq = getBuilder(baseUrl, request, bodyPublisher, additionalHeaders);
    return httpClient.sendAsync(forwardReq.build(), new ForwardBodyHandler(response))
            .thenApply(resp -> null);
  }

  private CompletableFuture<Void> doForward(String baseurl, HttpServletRequest request, HttpServletResponse response, HttpRequest.BodyPublisher bodyPublisher,
          Map<String, String> additionalHeaders, String parameters) throws IOException {
    HttpRequest.Builder forwardReq = getBuilder(baseurl, request, bodyPublisher, parameters, additionalHeaders);
    return httpClient.sendAsync(forwardReq.build(), new ForwardBodyHandler(response))
            .thenApply(resp -> null);
  }

  private HttpRequest.Builder getBuilder(String baseurl, HttpServletRequest request, HttpRequest.BodyPublisher bodyPublisher, Map<String, String> additionalHeaders) {
    var forwardReq = HttpRequest.newBuilder(resolveTargetUri(baseurl, request)).method(request.getMethod(), bodyPublisher);
    forwardHeaders(forwardReq, request);
    if (additionalHeaders != null && !additionalHeaders.isEmpty()) {
      additionalHeaders.forEach(forwardReq::setHeader);
    }
    return forwardReq;
  }

  private HttpRequest.Builder getBuilder(String baseUrl, HttpServletRequest request, HttpRequest.BodyPublisher bodyPublisher, String parameters, Map<String, String> additionalHeaders) {
    var forwardReq = HttpRequest.newBuilder(resolveTargetUri(baseUrl, request, parameters)).method(request.getMethod(), bodyPublisher);
    forwardHeaders(forwardReq, request);
    if (additionalHeaders != null && !additionalHeaders.isEmpty()) {
      additionalHeaders.forEach(forwardReq::setHeader);
    }
    return forwardReq;
  }

  private void forwardHeaders(HttpRequest.Builder builder, HttpServletRequest request) {
    var headers = request.getHeaderNames();
    String header;
    while (headers.hasMoreElements()) {
      header = headers.nextElement();
      if (DISALLOWED_HEADERS_SET.contains(header)) {
        continue;
      }
      var values = request.getHeaders(header);
      while (values.hasMoreElements()) {
        builder.header(header, values.nextElement());
      }
    }
  }

  private URI resolveTargetUri(String baseUrl, HttpServletRequest request) {
    var requestURI = request.getRequestURI();
    var builder = new StringBuilder()
            .append(baseUrl)
            .append(requestURI, ignorePrefixLength, requestURI.length());
    if (request.getQueryString() != null) {
      builder.append('?').append(request.getQueryString());
    }
    return URI.create(builder.toString());
  }

  private URI resolveTargetUri(String baseUrl, HttpServletRequest request, String parameters) {
    var requestURI = request.getRequestURI();
    var builder = new StringBuilder()
            .append(baseUrl)
            .append(requestURI, ignorePrefixLength, requestURI.length());
    addParameter(builder, request, parameters);
    return URI.create(builder.toString());
  }

  private void addParameter(StringBuilder requestURL, HttpServletRequest request, String parameters) {
    String queryString = request.getQueryString();
    if (queryString == null && parameters == null) return;
    requestURL.append('?');
    if (queryString != null) {
      requestURL.append(queryString);
    }
    if (StringUtils.hasText(parameters)) {
      requestURL.append('&').append(parameters);
    }
  }
}
