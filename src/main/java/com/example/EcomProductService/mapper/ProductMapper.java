package com.example.EcomProductService.mapper;

import com.example.EcomProductService.dto.FakeStoreProductRequestDto;
import com.example.EcomProductService.dto.FakeStoreProductResponseDto;
import com.example.EcomProductService.dto.ProductRequestDto;
import com.example.EcomProductService.dto.ProductResponseDto;
import com.example.EcomProductService.model.Category;
import com.example.EcomProductService.model.Price;
import com.example.EcomProductService.model.Product;
import org.modelmapper.ModelMapper;

import java.util.List;

public class ProductMapper {

    private static ModelMapper modelMapper;

    public static FakeStoreProductRequestDto productRequestToFakeStoreRequest(ProductRequestDto productRequestDto) {
//        FakeStoreProductRequestDto fakeStoreProductRequestDto = new FakeStoreProductRequestDto();
//        fakeStoreProductRequestDto.setCategory(productRequestDto.getCategory());
//        fakeStoreProductRequestDto.setImage(productRequestDto.getImage());
//        fakeStoreProductRequestDto.setDescription(productRequestDto.getDescription());
//        fakeStoreProductRequestDto.setPrice(productRequestDto.getPrice());
//        fakeStoreProductRequestDto.setTitle(productRequestDto.getTitle());
//        return fakeStoreProductRequestDto;
        modelMapper = new ModelMapper();
        return modelMapper.map(productRequestDto, FakeStoreProductRequestDto.class);
    }

    public static ProductResponseDto fakeStoreResponseToProductResponse(FakeStoreProductResponseDto fakeStoreProductResponseDto) {
//        ProductResponseDto productResponseDto = new ProductResponseDto();
//        productResponseDto.setDescription(fakeStoreProductResponseDto.getDescription());
//        productResponseDto.setImage(fakeStoreProductResponseDto.getImage());
//        productResponseDto.setTitle(fakeStoreProductResponseDto.getTitle());
//        productResponseDto.setPrice(fakeStoreProductResponseDto.getPrice());
//        productResponseDto.setCategory(fakeStoreProductResponseDto.getCategory());
//        return productResponseDto;
        modelMapper = new ModelMapper();
        return modelMapper.map(fakeStoreProductResponseDto, ProductResponseDto.class);
    }

    public static ProductResponseDto productToProductResponseDto(Product product) {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(product.getId());
        productResponseDto.setTitle(product.getTitle());
        productResponseDto.setDescription(product.getDescription());
        productResponseDto.setImage(product.getImage());
        productResponseDto.setPrice(product.getPrice().getAmount());
        productResponseDto.setCategory(product.getCategory().getCategoryName());
        return productResponseDto;
    }

    public static Product productRequestDtoToProduct(ProductRequestDto productRequestDto) {
        Category category = new Category();
        category.setCategoryName(productRequestDto.getCategory());
        Price price = new Price();
        price.setAmount(productRequestDto.getPrice());
        price.setCurrency("INR");
        price.setDiscount(0.0);
        Product product = new Product();
        product.setTitle(productRequestDto.getTitle());
        product.setDescription(productRequestDto.getDescription());
        product.setImage(productRequestDto.getImage());
        product.setCategory(category);
        product.setPrice(price);
        return product;
    }
}
