package com.example.springdemo.errors;

import org.springframework.http.HttpStatus;

public enum ApiErrorCode implements ErrorCode{

    GENERIC_DEVELOPER_ERROR(HttpStatus.CONFLICT, "There is a generic developer error!"),
    HUMAN_NOT_FOUND(HttpStatus.NOT_FOUND, "Human not found");

    private final String errorCode;
    private final HttpStatus httpStatus;
    private final String message;

    ApiErrorCode(String errorCode, HttpStatus httpStatus, String message) {
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.message = message;
    }

    ApiErrorCode(HttpStatus httpStatus, String message) {
        this.errorCode = this.name();
        this.message = message;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
