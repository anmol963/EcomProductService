package com.example.EcomProductService.service;
import com.example.EcomProductService.dto.ProductListResponseDto;
import com.example.EcomProductService.dto.ProductRequestDto;
import com.example.EcomProductService.dto.ProductResponseDto;
import com.example.EcomProductService.exceptions.ProductNotFoundException;
import com.example.EcomProductService.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    ProductListResponseDto getAllProducts();

    ProductResponseDto getProductById(UUID id) throws ProductNotFoundException;

    ProductResponseDto createProduct(ProductRequestDto productRequestDto);

    ProductResponseDto deleteProduct(UUID id) throws ProductNotFoundException;

    ProductResponseDto updateProduct(ProductRequestDto productRequestDto, UUID id) throws ProductNotFoundException;

    ProductResponseDto findProductByTitle(String title);

    ProductResponseDto findProductByTitleAndDescription(String title, String description);

    ProductResponseDto findProductByTitleOrDescription(String title, String description);

    ProductResponseDto findProductByPrice(double amount);

    ProductResponseDto findProductByPriceLessThan(double amount);

    ProductResponseDto findProductByPriceBetween(double minPrice, double maxPrice);

    List<ProductResponseDto> findProductByCategoryName(String categoryName);
}
