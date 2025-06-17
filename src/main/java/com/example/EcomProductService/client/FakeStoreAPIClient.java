package com.example.EcomProductService.client;

import com.example.EcomProductService.dto.FakeStoreProductRequestDto;
import com.example.EcomProductService.dto.FakeStoreProductResponseDto;
import com.example.EcomProductService.dto.ProductRequestDto;
import com.example.EcomProductService.dto.ProductResponseDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

// we replace repo layer with a fake store API client
// This client will be used to interact with the fake store API for product operations
@Component
public class FakeStoreAPIClient {

    public RestTemplateBuilder restTemplateBuilder;

    public FakeStoreAPIClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public FakeStoreProductResponseDto createProduct(FakeStoreProductRequestDto productRequestDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = "https://fakestoreapi.com/products";
        FakeStoreProductResponseDto productResponseDto =
                restTemplate.postForEntity(url, productRequestDto, FakeStoreProductResponseDto.class).getBody();
        return productResponseDto;
    }

    public FakeStoreProductResponseDto getProductById(int id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = "https://fakestoreapi.com/products/" + id;
        FakeStoreProductResponseDto fakeStoreProductResponseDto =
                restTemplate.getForEntity(url, FakeStoreProductResponseDto.class).getBody();
        return fakeStoreProductResponseDto;
    }

    public List<FakeStoreProductResponseDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = "https://fakestoreapi.com/products";
        FakeStoreProductResponseDto[] productResponseArray =
                restTemplate.getForEntity(url, FakeStoreProductResponseDto[].class).getBody();
        return Arrays.asList(productResponseArray);
    }

    public FakeStoreProductResponseDto deleteProduct(int id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = "https://fakestoreapi.com/products/" + id;
        FakeStoreProductResponseDto response =
                restTemplate.exchange(url, HttpMethod.DELETE, null, FakeStoreProductResponseDto.class).getBody();
        return response;
    }
}
