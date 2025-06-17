package com.example.EcomProductService.service;
import com.example.EcomProductService.dto.ProductListResponseDto;
import com.example.EcomProductService.dto.ProductRequestDto;
import com.example.EcomProductService.dto.ProductResponseDto;
import com.example.EcomProductService.model.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("fakeStoreService")
@Primary // This annotation indicates that this service should be the primary bean of type ProductService
public class FakeStoreServiceImpl implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;

    FakeStoreServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public ProductListResponseDto getAllProducts() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://fakestoreapi.com/products";
        /*
         here to avoid the issue of type erasure, we use ProductResponseDto[].class
         ideally we should use DTO to interact with FakeStore API
        ProductResponseDto[] productResponse =
                restTemplate.getForEntity(url, ProductResponseDto[].class).getBody();

        Using ParameterizedTypeReference to handle the generic type
        ArrayList<ProductResponseDto> productResponse =
                restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<ArrayList<ProductResponseDto>>() {}).getBody();
        return productResponse;
         */
        ProductResponseDto[] productResponse =
                restTemplate.getForEntity(url, ProductResponseDto[].class).getBody();
        ProductListResponseDto productListResponseDto = new ProductListResponseDto();
        Arrays.stream(productResponse).forEach(product -> productListResponseDto.getProducts().add(product));
        return productListResponseDto;
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
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = "https://fakestoreapi.com/products";
        ProductResponseDto productResponseDto =
                restTemplate.postForEntity(url, productRequestDto, ProductResponseDto.class).getBody();
        return productResponseDto;
    }

    @Override
    public ProductResponseDto deleteProduct(int id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = "https://fakestoreapi.com/products/" + id;
        ProductResponseDto productResponseDto =
                restTemplate.exchange(url, HttpMethod.DELETE, null, ProductResponseDto.class).getBody();
        return productResponseDto;
    }

    @Override
    public Product updateProduct(int id, Product product) {
        return null;
    }
}
