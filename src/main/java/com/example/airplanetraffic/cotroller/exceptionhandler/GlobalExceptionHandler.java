package com.example.airplanetraffic.cotroller.exceptionhandler;

import com.example.airplanetraffic.facade.exception.CommonException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CommonException.class)
    public ResponseEntity<String> handleValidationException(CommonException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
