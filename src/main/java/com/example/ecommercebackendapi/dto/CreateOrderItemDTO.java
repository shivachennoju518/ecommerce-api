package com.example.ecommercebackendapi.dto;

import lombok.Data;

@Data
public class CreateOrderItemDTO {
    private Long productId;

    private int quantity;
}
