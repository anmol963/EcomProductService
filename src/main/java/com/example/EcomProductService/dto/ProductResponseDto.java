package com.example.EcomProductService.dto;
import com.example.EcomProductService.model.Category;
import com.example.EcomProductService.model.Price;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductResponseDto {

    private UUID id;

    private String title;

    private String description;

    private String image;

    private double price;

    private String category;
}
