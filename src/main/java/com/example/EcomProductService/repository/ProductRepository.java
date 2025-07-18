package com.example.EcomProductService.repository;

import com.example.EcomProductService.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    Product findByTitle(String title);


    Product findByTitleAndDescription(String title, String description);

    Product findByTitleOrDescription(String title, String description);

    Product findByPrice_AmountLessThan(double amount);

    Product findByPrice_Amount(double amount);

    Product findByPrice_AmountBetween(double minPrice, double maxPrice);

    List<Product> findByCategory_CategoryName(String categoryName);
    // custome sql queries can also be done in JPA

}
