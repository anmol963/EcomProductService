package com.example.EcomProductService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Product {

    private int id;

    private String title;

    private double price;

    private String category;

    private String description;

    private String image;
}
