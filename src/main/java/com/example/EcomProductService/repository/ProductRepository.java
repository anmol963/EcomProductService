package com.example.EcomProductService.repository;

import com.example.EcomProductService.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    Product findByTitle(String title);

    Product findByTitleAndDescription(String title, String description);

    Product findByTitleOrDescription(String title, String description);

    Product findByPriceLessThan(double price);

    Product findPriceLessThanEqual(double price);

    Product findByPriceGreaterThan(double price);

    Product findByPriceGreaterThanEqual(double price);

    Product findByPriceBetween(double minPrice, double maxPrice);

    // custome sql queries can also be done in JPA
}
