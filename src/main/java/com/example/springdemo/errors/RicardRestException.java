package com.example.springdemo.errors;

import org.springframework.http.HttpStatus;

import java.io.Serial;

public class RicardRestException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;
    private final String errorCode;
    private final String message;
    private final HttpStatus httpStatus;

    public <T extends ErrorCode> RicardRestException(T errorCode) {
        super(errorCode.getMessage(), null);
        this.errorCode = errorCode.getErrorCode();
        this.message = errorCode.getMessage();
        this.httpStatus = errorCode.getHttpStatus();
    }

    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
