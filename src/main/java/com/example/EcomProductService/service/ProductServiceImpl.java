package com.example.EcomProductService.service;
import com.example.EcomProductService.dto.ProductListResponseDto;
import com.example.EcomProductService.dto.ProductRequestDto;
import com.example.EcomProductService.dto.ProductResponseDto;
import static com.example.EcomProductService.mapper.ProductMapper.productToProductResponseDto;
import com.example.EcomProductService.model.Product;
import com.example.EcomProductService.repository.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
@Primary
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductListResponseDto getAllProducts() {
        List<Product> products = productRepository.findAll();
        ProductListResponseDto productListResponseDto = new ProductListResponseDto();
        products.forEach(product ->
                productListResponseDto.getProducts()
                        .add(productToProductResponseDto(product)));
        return productListResponseDto;
    }

    @Override
    public ProductResponseDto getProductById(int id) {
        return null;
    }

    @Override
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        return null;
    }

    @Override
    public ProductResponseDto deleteProduct(int id) {
        return null;
    }

    @Override
    public ProductResponseDto updateProduct(ProductRequestDto productRequestDto, int id) {
        return null;
    }

    @Override
    public ProductResponseDto findProductByTitle(String title) {
        Product product = this.productRepository.findByTitle(title);
        return productToProductResponseDto(product);
    }
}
