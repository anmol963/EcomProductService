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
import java.util.UUID;

@RestController
public class ProductController {

    private ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<ProductListResponseDto> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable("id") UUID id) throws ProductNotFoundException {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping("/products")
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductRequestDto productRequestDto) {
        return ResponseEntity.ok(productService.createProduct(productRequestDto));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<ProductResponseDto> deleteProduct(@PathVariable UUID id) throws ProductNotFoundException {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(@RequestBody ProductRequestDto productRequestDto, @PathVariable UUID id) throws ProductNotFoundException {
        return ResponseEntity.ok(productService.updateProduct(productRequestDto, id));
    }

    @GetMapping("/products/title")
    public ResponseEntity<ProductResponseDto> findProductByTitle(@RequestParam String title) {
        return ResponseEntity.ok(productService.findProductByTitle(title));
    }

    @GetMapping("producst/title/description")
    public ResponseEntity<ProductResponseDto> findProductByTitleAndDescription(@RequestParam String title, @RequestParam String description) {
        return ResponseEntity.ok(productService.findProductByTitleAndDescription(title, description));
    }

    @GetMapping("/products/category")
    public ResponseEntity<List<ProductResponseDto>> findProductByCategory(@RequestParam String categoryName) {
        return ResponseEntity.ok(productService.findProductByCategoryName(categoryName));
    }
}

