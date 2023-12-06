package com.example.springdemo.products.dto;

import lombok.Data;

@Data
public class ProductsFilterParamsDTO extends LimitedParamsDTO {

    private String name;

}
