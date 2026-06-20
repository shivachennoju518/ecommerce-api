package com.example.ecommercebackendapi.mapper;

import com.example.ecommercebackendapi.dto.OrderDTO;
import com.example.ecommercebackendapi.dto.OrderItemDTO;
import com.example.ecommercebackendapi.entity.Order;
import com.example.ecommercebackendapi.entity.OrderItem;

import java.util.List;

public class OrderMapper {
    public static OrderDTO toDTO(Order order) {
        OrderDTO dto = new OrderDTO();

        dto.setId(order.getId());
        dto.setUserId(order.getUser().getId());
        dto.setStatus(order.getStatus().name());
        dto.setTotalAmount(order.getTotAmount());

        List<OrderItemDTO> items = order.getOrderItem().stream()
                .map(OrderMapper::toItemDTO)
                .toList();

        dto.setOrderItems(items);

        return dto;
    }
        public static OrderItemDTO toItemDTO (OrderItem item){

            OrderItemDTO dto = new OrderItemDTO();

            dto.setProductId(item.getProduct().getId());
            dto.setProductName(item.getProduct().getName());
            dto.setQuantity(item.getQuantity());
            dto.setPrice(item.getPrice());
            return dto;
        }
    }
