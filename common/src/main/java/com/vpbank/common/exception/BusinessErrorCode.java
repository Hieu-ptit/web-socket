package com.vpbank.common.exception;

import lombok.Value;

@Value
public class BusinessErrorCode {
    int code;
    String message;
    int httpStatus;
}
