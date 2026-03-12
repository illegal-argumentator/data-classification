package com.nick_brogden.data_classification.adapter.server.in.exception;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.Map;

@Data
@Builder
public class ExceptionResponse {

    private final Instant timestamp = Instant.now();
    private String message;
    private Map<String, String> errors;
    private int code;
    private String path;

}
