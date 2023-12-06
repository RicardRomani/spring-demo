package com.example.springdemo.products;

import com.example.springdemo.products.dto.ProductsFilterParamsDTO;
import com.example.springdemo.products.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductsRepository {

    public List<Product> productList;

    public ProductsRepository(){
        this.productList = populateProducts();
    }

    private List<Product> populateProducts() {
        productList = new ArrayList<>();
        productList.add(new Product("COFFEE LATTE", 2.8, "Coffee with milk"));
        productList.add(new Product("COFFEE ONLY", 1.3, "Coffee only"));
        productList.add(new Product("WATER 330CL", 1.3, "Water 330cl"));
        productList.add(new Product("WATER 750cl", 2.4, "Water 770cl"));
        productList.add(new Product("CROISSANT", 1.6, "Croissant"));
        productList.add(new Product("CHOCO CROISSANT", 1.8, "Croissant with chocolate"));
        return productList;
    }

    public List<Product> getProducts(ProductsFilterParamsDTO params) {
        productList.stream().limit(params.getLimit());
        return productList;
    }
}
