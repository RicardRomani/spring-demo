package com.example.springdemo.products.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Product implements Serializable {

    private static Integer COUNT = 0;

    private Integer id;
    private String name;
    private Double price;
    private String description;

    public Product(String name, Double price, String description) {
        this.id = ++COUNT;
        this.name = name;
        this.price = price;
        this.description = description;
    }
}
