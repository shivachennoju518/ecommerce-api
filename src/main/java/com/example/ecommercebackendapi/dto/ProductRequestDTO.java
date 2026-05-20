package com.example.ecommercebackendapi.dto;

import lombok.Data;

@Data
public class ProductRequestDTO {
    private String name;
    private Double price;
    private Integer stock;
    private Long categoryId;
}
