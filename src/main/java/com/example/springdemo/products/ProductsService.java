package com.example.springdemo.products;

import com.example.springdemo.products.dto.MetadataDTO;
import com.example.springdemo.products.dto.ProductResponseDTO;
import com.example.springdemo.products.dto.ProductsFilterParamsDTO;
import com.example.springdemo.products.dto.ProductsResponseDTO;
import com.example.springdemo.products.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    private final ProductsRepository productsRepository;

    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public ProductsResponseDTO getProducts(ProductsFilterParamsDTO params) {
        List<Product> products = productsRepository.getProducts(params);
        ProductsResponseDTO response = new ProductsResponseDTO();
        List<ProductResponseDTO> data = products.stream().map(ProductsConverter::toDTO).toList();
        response.setData(data);
        response.setMetadata(MetadataDTO.Builder.build(products, params));
        return response;
    }
}
