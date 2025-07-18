package com.example.EcomProductService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Entity(name = "ecom_order")
@Data
public class Order extends BaseModel{

    private double totalPrice;

    @ManyToMany
    private List<Product> products;
}


/*
    Product       Order
    1               m
    m               1
    Many to many does not need to be bi-directional.
    For example, when we search for a product on an ecommerce app, it doesn't show us the orders
    that contain that product.
    So there is no need to have a reference of order in product.
 */