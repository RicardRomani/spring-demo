package com.example.springdemo.products.dto;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class LimitedParamsDTO {

    @Min(value = 1, message = "Param 'limit' must be greater than 0")
    private Integer limit = 500;
    @Min(value = 0, message = "Param 'offset' must be equal or greater than 0")
    private Integer offset = 0;
}
