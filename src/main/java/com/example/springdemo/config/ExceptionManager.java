package com.example.springdemo.config;

import com.example.springdemo.errors.RicardRestException;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serial;
import java.io.Serializable;

@ControllerAdvice
public class ExceptionManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionManager.class);

    @ExceptionHandler(RicardRestException.class)
    public @ResponseBody
    ResponseEntity<ApiErrorResponseDTO> errorHandler(HttpServletRequest req, RicardRestException e) {
        LOGGER.error(LogFormatter.apiErrorCodeFormat(), req.getRequestURL(), e.getErrorCode(), e.getMessage());
        e.printStackTrace();
        ApiErrorResponseDTO apiErrorResponseDTO = new ApiErrorResponseDTO(e.getErrorCode(), e.getMessage());
        return new ResponseEntity<>(apiErrorResponseDTO, e.getHttpStatus());
    }

    private record ApiErrorResponseDTO(String code, String message) implements Serializable {
        @Serial
        private static final long serialVersionUID = 1L;
    }

}