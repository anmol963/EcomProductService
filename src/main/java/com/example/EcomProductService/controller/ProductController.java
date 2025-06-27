package com.example.EcomProductService.controller;

import com.example.EcomProductService.dto.ProductListResponseDto;
import com.example.EcomProductService.dto.ProductRequestDto;
import com.example.EcomProductService.dto.ProductResponseDto;
import com.example.EcomProductService.exceptions.ProductNotFoundException;
import com.example.EcomProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

//    @Autowired
    ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    @GetMapping("/products")
    public ResponseEntity<ProductListResponseDto> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable("id") int id) throws ProductNotFoundException {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping("/products")
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductRequestDto productRequestDto) {
        return ResponseEntity.ok(productService.createProduct(productRequestDto));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<ProductResponseDto> deleteProduct(@PathVariable int id) throws ProductNotFoundException {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(@RequestBody ProductRequestDto productRequestDto, @PathVariable int id) {
        return ResponseEntity.ok(productService.updateProduct(productRequestDto, id));
    }
}

