package com.example.ecommercebackendapi.service;

import com.example.ecommercebackendapi.dto.CreateOrderDTO;
import com.example.ecommercebackendapi.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    OrderDTO placeOrder(CreateOrderDTO request);
    OrderDTO getOrderById(Long orderId);

    List<OrderDTO> getAllOrders();

    List<OrderDTO> getOrdersByUserId(Long userId);

    void cancelOrder(Long orderId);


}
