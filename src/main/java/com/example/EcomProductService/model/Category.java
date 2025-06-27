package com.example.EcomProductService.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "categories")
public class Category extends BaseModel {

    private String categoryName;
}
