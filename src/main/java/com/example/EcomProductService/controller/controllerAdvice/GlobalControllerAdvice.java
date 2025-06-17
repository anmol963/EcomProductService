package com.example.EcomProductService.controller.controllerAdvice;

import com.example.EcomProductService.dto.ErrorresponseDto;
import com.example.EcomProductService.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {

    // This class can be used to handle global exceptions, logging, etc.
    // You can add methods annotated with @ExceptionHandler to handle specific exceptions globally.

    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<ErrorresponseDto> handleProductNotFoundException(Exception e) {
        ErrorresponseDto errorresponseDto = new ErrorresponseDto();
        errorresponseDto.setMessage(e.getMessage());
        errorresponseDto.setMessageCode(404);

        return new ResponseEntity<>(errorresponseDto, HttpStatus.NOT_FOUND);
    }
}
