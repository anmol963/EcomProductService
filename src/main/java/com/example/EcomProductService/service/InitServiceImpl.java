package com.example.EcomProductService.service;
import com.example.EcomProductService.model.Category;
import com.example.EcomProductService.model.Order;
import com.example.EcomProductService.model.Price;
import com.example.EcomProductService.model.Product;
import com.example.EcomProductService.repository.CategoryRepository;
import com.example.EcomProductService.repository.OrderRepository;
import com.example.EcomProductService.repository.PriceRepository;
import com.example.EcomProductService.repository.ProductRepository;
import com.zaxxer.hikari.util.IsolationLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InitServiceImpl implements InitiService{

    private ProductRepository productRepository;

    private PriceRepository priceRepository;

    private CategoryRepository categoryRepository;

    private OrderRepository orderRepository;

    @Autowired // not required if using constructor injection with @Service
    public InitServiceImpl(ProductRepository productRepository,
                           PriceRepository priceRepository,
                           CategoryRepository categoryRepository,
                           OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
        this.categoryRepository = categoryRepository;
        this.orderRepository = orderRepository;
    }

//    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public void initialize() {


    }
}
