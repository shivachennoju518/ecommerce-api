package com.example.ecommercebackendapi.dto;

import lombok.Data;

@Data
public class ProductResponseDTO {
    private Long id;

    private String name;

    private double price;

    private int stock;

    private String description;

    // safe category info (no full entity)
    private Long categoryId;

    private String categoryName;
}
