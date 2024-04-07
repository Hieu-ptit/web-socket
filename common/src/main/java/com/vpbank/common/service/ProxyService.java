package com.vpbank.common.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public interface ProxyService {
  CompletableFuture<Void> forward(String baseUrl, HttpServletRequest request, HttpServletResponse response, Map<String, String> additionalHeaders) throws IOException;

  CompletableFuture<Void> forwardWithParams(String baseUrl, HttpServletRequest request, HttpServletResponse response, String parameters, Map<String, String> additionalHeaders) throws IOException;

  CompletableFuture<HttpResponse<byte[]>> forwardRequest(String baseUrl, HttpServletRequest request, Map<String, String> additionalHeaders);

  CompletableFuture<Void> forwardWithBody(String baseUrl, HttpServletRequest request, HttpServletResponse response, Object body, Map<String, String> additionalHeaders) throws IOException;

  CompletableFuture<Void> forwardWithBody(String baseUrl, HttpServletRequest request, HttpServletResponse response, byte[] body, Map<String, String> additionalHeaders) throws IOException;

  CompletableFuture<Void> forwardWithFormData(String baseUrl, HttpServletRequest request, HttpServletResponse response, Map<String, Object> formData, Map<String, String> additionalHeaders) throws IOException;
}
