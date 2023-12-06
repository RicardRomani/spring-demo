package com.example.springdemo.products.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductResponseDTO implements Serializable {

    private Integer id;
    private String name;
    private Double price;
    private String description;

}
