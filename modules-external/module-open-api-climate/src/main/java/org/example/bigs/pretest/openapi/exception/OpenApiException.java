package org.example.bigs.pretest.openapi.exception;

public class OpenApiException extends RuntimeException {

    public static final String DEFAULT_MESSAGE = "[ERROR] error occur while use open api.";

    public OpenApiException() {
        super(DEFAULT_MESSAGE);
    }

    public OpenApiException(String message) {
        super(message);
    }

}
