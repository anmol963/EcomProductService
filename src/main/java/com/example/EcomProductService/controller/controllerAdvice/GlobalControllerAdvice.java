package com.example.EcomProductService.controller.controllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {

    // This class can be used to handle global exceptions, logging, etc.
    // You can add methods annotated with @ExceptionHandler to handle specific exceptions globally.

    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(Exception e) {
        String exceptionMessage =
                "error : " + e.getMessage() + ", code : " + HttpStatus.INTERNAL_SERVER_ERROR;
        return ResponseEntity.ok(exceptionMessage);
    }
}
