package com.example.EcomProductService.model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
public class Price extends BaseModel{

    private String currency;

    private double amount;

    private double discount;
}
