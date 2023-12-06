package com.example.springdemo.products.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class MetadataDTO {
    private Integer limit;
    private Integer offset;
    private Integer total;

    public static class Builder {

        static public <T extends Serializable, P extends LimitedParamsDTO> MetadataDTO build(List<T> data, P params){
            MetadataDTO metadata = new MetadataDTO();
            metadata.setLimit(params.getLimit());
            metadata.setOffset(params.getOffset());
            metadata.setTotal(data.size());
            return metadata;
        }
    }
}