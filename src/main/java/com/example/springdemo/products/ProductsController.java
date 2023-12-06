package com.example.springdemo.products;

import com.example.springdemo.config.ApiConfig;
import com.example.springdemo.products.dto.ProductsFilterParamsDTO;
import com.example.springdemo.products.dto.ProductsResponseDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ProductsController.BASE_URI)
public class ProductsController {

    static final String BASE_URI = ApiConfig.BASE_URL + "/products";

    private final ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping
    public ProductsResponseDTO searchProducts(@Valid ProductsFilterParamsDTO params){
        return productsService.getProducts(params);
    }
}
