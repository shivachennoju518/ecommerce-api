package com.example.ecommercebackendapi.dto;

import com.example.ecommercebackendapi.entity.OrderItem;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CreateOrderDTO {
    @NotNull
    private Long userId;
    private List<CreateOrderItemDTO> items;
}
