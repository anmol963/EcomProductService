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
    public ResponseEntity<ProductResponseDto> deleteProduct(@PathVariable int id) {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }
}
/*
        ProductResponseDto p1 = new ProductResponseDto();
        p1.setId(2);
        p1.setTitle("Iphone 14");
        p1.setPrice(150000.0);
        p1.setCategory("Electronics");
        p1.setDescription("Kafi Mehga Phone");
        p1.setImage("www.google.com/images/iphone14");

        ProductResponseDto p2 = new ProductResponseDto();
        p2.setId(3);
        p2.setTitle("Samsung Galaxy S23");
        p2.setPrice(120000.0);
        p2.setCategory("Electronics");
        p2.setDescription("Latest Samsung flagship phone");
        p2.setImage("www.google.com/images/samsunggalaxys23");

        List<ProductResponseDto> products = Arrays.asList(p1, p2);
        return ResponseEntity.ok(products);
 */
