package com.example.EcomProductService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity (name = "products")
public class Product extends BaseModel {

    private String title;

    private double price;

    private String description;

    private String image;

    @ManyToOne
    private Category category;
}
