package com.example.EcomProductService.service;

import com.example.EcomProductService.dto.ProductListResponseDto;
import com.example.EcomProductService.dto.ProductResponseDto;
import com.example.EcomProductService.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Override
    public List<ProductResponseDto> getAllProducts() {
        return null;
    }

    @Override
    public ProductResponseDto getProductById(int id) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(int id) {
        return null;
    }

    @Override
    public Product updateProduct(int id, Product product) {
        return null;
    }
}
