package com.example.EcomProductService.dto;

import com.example.EcomProductService.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ProductListResponseDto {

    private List<ProductResponseDto> products;

    public ProductListResponseDto() {
        products = new ArrayList<>();
    }
}
