package com.example.ecommercebackendapi.controller;

import com.example.ecommercebackendapi.dto.CreateOrderDTO;
import com.example.ecommercebackendapi.dto.OrderDTO;
import com.example.ecommercebackendapi.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController{
    private final OrderService orderService;

  @PostMapping()
    public OrderDTO placeOrder(@Valid @RequestBody CreateOrderDTO request) {
      System.out.println(request);
      return orderService.placeOrder(request);
  }

    @GetMapping("/{orderId}")
    public OrderDTO getOrderById(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @GetMapping
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/user/{userId}")
    public List<OrderDTO> getOrdersByUserId(@PathVariable Long userId) {
        return orderService.getOrdersByUserId(userId);
    }

    @PutMapping("/{orderId}/cancel")
    public String cancelOrder(@PathVariable Long orderId) {

        orderService.cancelOrder(orderId);

        return "Order cancelled successfully";
    }
}
