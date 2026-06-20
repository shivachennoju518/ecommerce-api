package com.example.ecommercebackendapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartResponseDTO {
    private Long userId;

    private List<CartItemDTO> items;

    private Double totalPrice;



}
