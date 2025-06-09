package com.example.EcomProductService.service;

import com.example.EcomProductService.dto.ProductListResponseDto;
import com.example.EcomProductService.dto.ProductResponseDto;
import com.example.EcomProductService.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    List<ProductResponseDto> getAllProducts();

    ProductResponseDto getProductById(int id);

    Product createProduct(Product product);

    Product deleteProduct(int id);

    Product updateProduct(int id, Product product);
}
