package com.example.EcomProductService.service;

import com.example.EcomProductService.dto.ProductListResponseDto;
import com.example.EcomProductService.dto.ProductResponseDto;
import com.example.EcomProductService.model.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;

@Service("fakeStoreService")
public class FakeStoreServiceImpl implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;

    FakeStoreServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = "https://fakestoreapi.com/products";
        // here to avoid the issue of type erasure, we use ProductResponseDto[].class
        // ideally we should use DTO to interact with FakeStore API
        ProductResponseDto[] productResponse =
                restTemplate.getForEntity(url, ProductResponseDto[].class).getBody();
        return Arrays.asList(productResponse);
    }

    @Override
    public ProductResponseDto getProductById(int id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = "https://fakestoreapi.com/products/" + id;
        ProductResponseDto productResponse =
                restTemplate.getForEntity(url, ProductResponseDto.class).getBody();
        return productResponse;
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
