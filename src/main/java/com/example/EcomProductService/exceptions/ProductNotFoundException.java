package com.example.EcomProductService.exceptions;

public class ProductNotFoundException extends Exception{

    public ProductNotFoundException(String message) {
        super(message);
    }
}
