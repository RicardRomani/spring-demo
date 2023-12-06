package com.example.springdemo.products;

import com.example.springdemo.products.dto.ProductResponseDTO;
import com.example.springdemo.products.model.Product;

public class ProductsConverter {

    public static ProductResponseDTO toDTO(Product product){
        ProductResponseDTO response = new ProductResponseDTO();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setPrice(product.getPrice());
        response.setDescription(product.getDescription());
        return response;
    }


}
