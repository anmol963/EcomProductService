package com.example.EcomProductService.service;
import com.example.EcomProductService.dto.ProductListResponseDto;
import com.example.EcomProductService.dto.ProductRequestDto;
import com.example.EcomProductService.dto.ProductResponseDto;
import static com.example.EcomProductService.mapper.ProductMapper.productToProductResponseDto;

import com.example.EcomProductService.exceptions.ProductNotFoundException;
import com.example.EcomProductService.model.Product;
import com.example.EcomProductService.repository.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import static com.example.EcomProductService.mapper.ProductMapper.productRequestDtoToProduct;

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
    public ProductResponseDto getProductById(UUID id) throws ProductNotFoundException {
        Optional<Product> optional = productRepository.findById(id);
        if(optional.isPresent()) {
            Product product = optional.get();
            return productToProductResponseDto(product);
        }else {
            throw new ProductNotFoundException("Product not found with id: " + id);
        }
    }

    @Override
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        Product product = productRequestDtoToProduct(productRequestDto);
        Product savedProduct = productRepository.save(product);
        return productToProductResponseDto(savedProduct);
    }

    @Override
    public ProductResponseDto deleteProduct(UUID id) throws ProductNotFoundException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
        productRepository.deleteById(id);
        return productToProductResponseDto(product);
    }

    @Override
    public ProductResponseDto updateProduct(ProductRequestDto productRequestDto, UUID id) throws ProductNotFoundException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
        product.setTitle(productRequestDto.getTitle());
        product.setDescription(productRequestDto.getDescription());
        product.setImage(productRequestDto.getImage());
        // we should not change the category or price in an product update operation
        // update of category and price should be done through category and price services/controllers
        Product updatedProduct = productRepository.save(product);
        return productToProductResponseDto(updatedProduct);
    }

    @Override
    public ProductResponseDto findProductByTitle(String title) {
        Product product = this.productRepository.findByTitle(title);
        return productToProductResponseDto(product);
    }

    @Override
    public ProductResponseDto findProductByTitleAndDescription(String title, String description) {
        return productToProductResponseDto(
                this.productRepository.findByTitleAndDescription(title, description));
    }

    @Override
    public ProductResponseDto findProductByTitleOrDescription(String title, String description) {
        return productToProductResponseDto(
                this.productRepository.findByTitleOrDescription(title, description));
    }

    @Override
    public ProductResponseDto findProductByPrice(double amount) {
        return productToProductResponseDto(
                this.productRepository.findByPrice_Amount(amount));
    }

    @Override
    public ProductResponseDto findProductByPriceLessThan(double amount) {
        return productToProductResponseDto(
                this.productRepository.findByPrice_AmountLessThan(amount));
    }

    @Override
    public ProductResponseDto findProductByPriceBetween(double minPrice, double maxPrice) {
        return productToProductResponseDto(
                this.productRepository.findByPrice_AmountBetween(minPrice, maxPrice));
    }

    @Override
    public List<ProductResponseDto> findProductByCategoryName(String categoryName) {
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        this.productRepository.findByCategory_CategoryName(categoryName)
                .forEach(product -> productResponseDtos.add(productToProductResponseDto(product)));
        return productResponseDtos;
    }
}
