package com.example.springdemo.products.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BaseResponseCollectionDTO<T extends Serializable> {

    private MetadataDTO metadata;
    private List<T> data;

}
