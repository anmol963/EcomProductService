package com.example.EcomProductService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductRequestDto {

    private String title;

    private double price;

    private String category;

    private String description;

    private String image;
}
