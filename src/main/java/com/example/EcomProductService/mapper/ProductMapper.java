package com.example.EcomProductService.mapper;

import com.example.EcomProductService.dto.FakeStoreProductRequestDto;
import com.example.EcomProductService.dto.FakeStoreProductResponseDto;
import com.example.EcomProductService.dto.ProductRequestDto;
import com.example.EcomProductService.dto.ProductResponseDto;
import org.modelmapper.ModelMapper;

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
}
