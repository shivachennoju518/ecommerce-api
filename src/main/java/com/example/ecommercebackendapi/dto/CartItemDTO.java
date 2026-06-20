package com.example.ecommercebackendapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDTO {

    private Long productId;

    private String productName;

    private Double price;

    private Integer quantity;

    private Double subTotal;


}
