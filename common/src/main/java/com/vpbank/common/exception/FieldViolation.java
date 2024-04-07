package com.vpbank.common.exception;

import lombok.Value;

@Value
public class FieldViolation {
    String field;
    String description;
}
