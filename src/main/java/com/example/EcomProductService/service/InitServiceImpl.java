package com.example.EcomProductService.service;

import com.example.EcomProductService.model.Category;
import com.example.EcomProductService.model.Order;
import com.example.EcomProductService.model.Price;
import com.example.EcomProductService.model.Product;
import com.example.EcomProductService.repository.CategoryRepository;
import com.example.EcomProductService.repository.OrderRepository;
import com.example.EcomProductService.repository.PriceRepository;
import com.example.EcomProductService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public void initialize() {
        Category electronics = new Category();
        electronics.setCategoryName("Electronics");
        // save call works for both: insert and update -> upsert
        electronics = categoryRepository.save(electronics);

        Price priceIphone = new Price();
        priceIphone.setCurrency("INR");
        priceIphone.setAmount(100000);
        priceIphone.setDiscount(0);

        Price priceMacbook = new Price();
        priceMacbook.setCurrency("INR");
        priceMacbook.setAmount(200000);
        priceMacbook.setDiscount(0);

        Price priceIwatch = new Price();
        priceIwatch.setCurrency("INR");
        priceIwatch.setAmount(40000);
        priceIwatch.setDiscount(0);

        priceIphone = priceRepository.save(priceIphone);
        priceMacbook = priceRepository.save(priceMacbook);
        priceIwatch = priceRepository.save(priceIwatch);

        Product iphone = new Product();
        iphone.setTitle("Iphone 14 Pro");
        iphone.setDescription("Iphone 14 Pro with 128GB storage");
        iphone.setImage("https://example.com/iphone14pro.jpg");
        iphone.setPrice(priceIphone);
        iphone.setCategory(electronics);
        iphone = productRepository.save(iphone);

        Product macbook = new Product();
        macbook.setTitle("Macbook M2");
        macbook.setDescription("Macbook M2 with 128GB storage");
        macbook.setImage("https://example.com/macbook14pro.jpg");
        macbook.setPrice(priceMacbook);
        macbook.setCategory(electronics);
        macbook = productRepository.save(macbook);

        Product iwatch = new Product();
        iwatch.setTitle("iwatch 14 Pro");
        iwatch.setDescription("iwatch 14 Pro with 128GB storage");
        iwatch.setImage("https://example.com/iwatch14pro.jpg");
        iwatch.setPrice(priceIwatch);
        iwatch.setCategory(electronics);
        iwatch = productRepository.save(iwatch);

        Order order = new Order();
        order.setProduct(List.of(iphone, macbook, iwatch));
        order = orderRepository.save(order);
    }
}
