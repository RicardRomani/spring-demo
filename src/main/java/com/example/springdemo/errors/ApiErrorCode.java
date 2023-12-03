package com.example.springdemo.errors;

import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

public enum ApiErrorCode implements ErrorCode{

    GENERIC_DEVELOPER_ERROR(CONFLICT, "There is a generic developer error!"),
    BAD_REQUEST_PARAMETER(BAD_REQUEST, "Some parameters are incorrect or invalid"),
    HUMAN_NOT_FOUND(NOT_FOUND, "Human not found");

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
