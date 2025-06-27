package com.example.EcomProductService.service;
import com.example.EcomProductService.client.FakeStoreAPIClient;
import com.example.EcomProductService.dto.*;
import com.example.EcomProductService.exceptions.ProductNotFoundException;
import com.example.EcomProductService.mapper.ProductMapper;
import com.example.EcomProductService.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

import static com.example.EcomProductService.mapper.ProductMapper.productRequestToFakeStoreRequest;
import static com.example.EcomProductService.mapper.ProductMapper.fakeStoreResponseToProductResponse;
import static com.example.EcomProductService.utils.ProductUtils.isNull;

@Service("fakeStoreService")
@Primary // This annotation indicates that this service should be the primary bean of type ProductService
public class FakeStoreServiceImpl implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;
    private FakeStoreAPIClient fakeStoreAPIClient;

    FakeStoreServiceImpl(RestTemplateBuilder restTemplateBuilder, FakeStoreAPIClient fakeStoreAPIClient) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreAPIClient = fakeStoreAPIClient;
    }

    @Override
    public ProductListResponseDto getAllProducts() {
        /*
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://fakestoreapi.com/products";
         here to avoid the issue of type erasure, we use ProductResponseDto[].class
         ideally we should use DTO to interact with FakeStore API
        ProductResponseDto[] productResponse =
                restTemplate.getForEntity(url, ProductResponseDto[].class).getBody();

        Using ParameterizedTypeReference to handle the generic type
        ArrayList<ProductResponseDto> productResponse =
                restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<ArrayList<ProductResponseDto>>() {}).getBody();
        return productResponse;

        ProductResponseDto[] productResponse =
                restTemplate.getForEntity(url, ProductResponseDto[].class).getBody();
        ProductListResponseDto productListResponseDto = new ProductListResponseDto();
        Arrays.stream(productResponse).forEach(product -> productListResponseDto.getProducts().add(product));
        return productListResponseDto;
         */
        List<FakeStoreProductResponseDto> listFakeStoreResponse = this.fakeStoreAPIClient.getAllProducts();
        ProductListResponseDto productListResponseDto = new ProductListResponseDto();
        listFakeStoreResponse.forEach(response ->
                productListResponseDto.getProducts().add(fakeStoreResponseToProductResponse(response)));
        return productListResponseDto;
    }


    @Override
    public ProductResponseDto getProductById(int id) throws ProductNotFoundException {
        FakeStoreProductResponseDto fakeStoreProductResponseDto = this.fakeStoreAPIClient.getProductById(id);
        if(isNull(fakeStoreProductResponseDto)) {
            throw new ProductNotFoundException("Product not found with id: " + id);
        }
        return fakeStoreResponseToProductResponse(fakeStoreProductResponseDto);
    }

    @Override
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        FakeStoreProductRequestDto fakeStoreProductRequestDto = productRequestToFakeStoreRequest(productRequestDto);
        FakeStoreProductResponseDto fakeStoreProductResponseDto = this.fakeStoreAPIClient.createProduct(fakeStoreProductRequestDto);
        return fakeStoreResponseToProductResponse(fakeStoreProductResponseDto);
    }

    @Override
    public ProductResponseDto deleteProduct(int id) throws ProductNotFoundException {
        ProductResponseDto productResponseDto = getProductById(id);
        if(isNull(productResponseDto)) {
            throw new ProductNotFoundException("Product not found with id: " + id);
        }
        FakeStoreProductResponseDto fakeStoreProductResponseDto = this.fakeStoreAPIClient.deleteProduct(id);
        return fakeStoreResponseToProductResponse(fakeStoreProductResponseDto);
    }

    @Override
    public ProductResponseDto updateProduct(ProductRequestDto productRequestDto, int id) {
        FakeStoreProductRequestDto fakeStoreProductRequestDto = productRequestToFakeStoreRequest(productRequestDto);
        FakeStoreProductResponseDto fakeStoreProductResponseDto = this.fakeStoreAPIClient.updateProduct(fakeStoreProductRequestDto, id);
        return fakeStoreResponseToProductResponse(fakeStoreProductResponseDto);
    }


}
