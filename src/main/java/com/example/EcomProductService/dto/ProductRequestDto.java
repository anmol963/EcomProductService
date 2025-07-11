package com.example.EcomProductService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductRequestDto {

    private String title;

    private double price;

    private String category;

    private String description;

    private String image;
}
