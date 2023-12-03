package com.example.springdemo.config;

import com.example.springdemo.errors.ApiErrorCode;
import com.example.springdemo.errors.RicardRestException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serial;
import java.io.Serializable;

@ControllerAdvice
@Slf4j
public class ExceptionManager {

    @ExceptionHandler(RicardRestException.class)
    public @ResponseBody
    ResponseEntity<ApiErrorResponseDTO> errorHandler(HttpServletRequest req, RicardRestException e) {
        log.error(LogFormatter.apiErrorCodeFormat(), req.getRequestURL(), e.getErrorCode(), e.getMessage());
        e.printStackTrace();
        ApiErrorResponseDTO apiErrorResponseDTO = new ApiErrorResponseDTO(e.getErrorCode(), e.getMessage(), null);
        return new ResponseEntity<>(apiErrorResponseDTO, e.getHttpStatus());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ApiErrorResponseDTO> handleError(HttpServletRequest req, MethodArgumentNotValidException e) {
        ObjectError error = null;
        if (e.getBindingResult().hasFieldErrors()) {
            error = e.getBindingResult().getFieldError();
        }
        if (e.getBindingResult().hasGlobalErrors()) {
            error = e.getBindingResult().getGlobalError();
        }
        ApiErrorCode apiErrorCode = ApiErrorCode.BAD_REQUEST_PARAMETER;
        log.error(LogFormatter.apiErrorCodeFormat(), req.getRequestURL(), apiErrorCode.getErrorCode(), apiErrorCode.getMessage());
        e.printStackTrace();
        ApiErrorResponseDTO apiErrorResponseDTO = new ApiErrorResponseDTO(apiErrorCode.getErrorCode(), apiErrorCode.getMessage(), error);
        return new ResponseEntity<>(apiErrorResponseDTO, apiErrorCode.getHttpStatus());
    }

    private record ApiErrorResponseDTO(String code, String message, ObjectError error) implements Serializable {
        @Serial
        private static final long serialVersionUID = 1L;
    }

}