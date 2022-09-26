package com.example.inditex.infrastructure.adapters.exception;

import com.example.inditex.domain.exception.PriceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePriceNotFoundException(PriceNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ErrorResponse.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .cause("PRICE NOT FOUND")
                .build(), HttpStatus.NOT_FOUND);
    }
}
