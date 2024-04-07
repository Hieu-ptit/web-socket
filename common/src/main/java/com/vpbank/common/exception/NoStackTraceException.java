package com.vpbank.common.exception;

public class NoStackTraceException extends RuntimeException {
    public NoStackTraceException(String message) {
        super(message, null, false, false);
    }
}
