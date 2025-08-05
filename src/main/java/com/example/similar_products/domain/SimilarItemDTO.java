package com.example.similar_products.domain;

import lombok.Data;

@Data
public class SimilarItemDTO {
    private String id;
    private String name;
    private Double price;
    private Boolean availability;
}
