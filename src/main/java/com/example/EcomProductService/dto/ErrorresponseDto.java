package com.example.EcomProductService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorresponseDto {

    private String message;
    private int messageCode;
}
