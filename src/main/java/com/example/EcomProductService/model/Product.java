package com.example.EcomProductService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Product extends BaseModel {

    private String title;

    private String description;

    private String image;

    @ManyToOne
    private Category category;

    @OneToOne
    private Price price;
}

/*
    Product - Category (M : 1)
    1      :     1
    M      :      1

    Product - Price
    1 INR 500 2%
    2 INR 500 2%
    (we can have multiple products with same price)
    (so changing the price of one product will not affect the other products)
    (that's why we are maintaining one to one relationship between Product and Price)

    ProductId     PriceId
    1             1
    2             1
    3             2
 */