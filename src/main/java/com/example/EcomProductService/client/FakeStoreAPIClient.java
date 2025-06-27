package com.example.EcomProductService.client;

import com.example.EcomProductService.dto.FakeStoreProductRequestDto;
import com.example.EcomProductService.dto.FakeStoreProductResponseDto;
import com.example.EcomProductService.dto.ProductRequestDto;
import com.example.EcomProductService.dto.ProductResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
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

    @Value("${fakestore.api.url}")
    private String fakeStoreApiUrl;

    @Value("${fakestore.api.path.product}")
    private String fakeStoreApiPathProduct;

    public FakeStoreAPIClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public FakeStoreProductResponseDto createProduct(FakeStoreProductRequestDto productRequestDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String createProductUrl = fakeStoreApiUrl + fakeStoreApiPathProduct;
        FakeStoreProductResponseDto productResponseDto =
                restTemplate.postForEntity(createProductUrl, productRequestDto, FakeStoreProductResponseDto.class).getBody();
        return productResponseDto;
    }

    public FakeStoreProductResponseDto getProductById(int id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = fakeStoreApiUrl + fakeStoreApiPathProduct + "/" + id;
        FakeStoreProductResponseDto fakeStoreProductResponseDto =
                restTemplate.getForEntity(url, FakeStoreProductResponseDto.class).getBody();
        return fakeStoreProductResponseDto;
    }

    public List<FakeStoreProductResponseDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = fakeStoreApiUrl + fakeStoreApiPathProduct;
        FakeStoreProductResponseDto[] productResponseArray =
                restTemplate.getForEntity(url, FakeStoreProductResponseDto[].class).getBody();
        return Arrays.asList(productResponseArray);
    }

    public FakeStoreProductResponseDto deleteProduct(int id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = fakeStoreApiUrl + fakeStoreApiPathProduct + "/" + id;
        FakeStoreProductResponseDto response =
                restTemplate.exchange(url, HttpMethod.DELETE, null, FakeStoreProductResponseDto.class).getBody();
        return response;
    }

    public FakeStoreProductResponseDto updateProduct(FakeStoreProductRequestDto productRequestDto, int id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = fakeStoreApiUrl + fakeStoreApiPathProduct + "/" + id;
        HttpEntity<FakeStoreProductRequestDto> productRequestEntity = new HttpEntity<>(productRequestDto);
        FakeStoreProductResponseDto productResponseDto =
                restTemplate.exchange(url, HttpMethod.PUT, productRequestEntity, FakeStoreProductResponseDto.class).getBody();
        return productResponseDto;
    }
}
