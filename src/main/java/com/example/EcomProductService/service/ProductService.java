package com.example.EcomProductService.service;
import com.example.EcomProductService.dto.ProductListResponseDto;
import com.example.EcomProductService.dto.ProductRequestDto;
import com.example.EcomProductService.dto.ProductResponseDto;
import com.example.EcomProductService.exceptions.ProductNotFoundException;
import com.example.EcomProductService.model.Product;

import java.util.List;

public interface ProductService {

    ProductListResponseDto getAllProducts();

    ProductResponseDto getProductById(int id) throws ProductNotFoundException;

    ProductResponseDto createProduct(ProductRequestDto productRequestDto);

    ProductResponseDto deleteProduct(int id) throws ProductNotFoundException;

    ProductResponseDto updateProduct(ProductRequestDto productRequestDto, int id) ;
}
