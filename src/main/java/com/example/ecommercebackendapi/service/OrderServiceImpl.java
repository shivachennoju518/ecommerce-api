package com.example.ecommercebackendapi.service;

import com.example.ecommercebackendapi.dto.CreateOrderDTO;
import com.example.ecommercebackendapi.dto.CreateOrderItemDTO;
import com.example.ecommercebackendapi.dto.OrderDTO;
import com.example.ecommercebackendapi.entity.Order;
import com.example.ecommercebackendapi.entity.OrderItem;
import com.example.ecommercebackendapi.entity.Product;
import com.example.ecommercebackendapi.entity.User;
import com.example.ecommercebackendapi.mapper.OrderMapper;
import com.example.ecommercebackendapi.repository.OrderRepository;
import com.example.ecommercebackendapi.repository.ProductRepository;
import com.example.ecommercebackendapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements  OrderService{
private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    @Override
    public OrderDTO placeOrder(CreateOrderDTO request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Order order = new Order();
        order.setUser(user);
        order.setStatus(Order.OrderStatus.PENDING);

        List<OrderItem> orderItems = new ArrayList<>();
        double totalAmount = 0;

        for (CreateOrderItemDTO itemDto : request.getItems()) {

            Product product = productRepository.findById(itemDto.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(product);
            orderItem.setQuantity(itemDto.getQuantity());
            orderItem.setPrice(product.getPrice());

            totalAmount += product.getPrice() * itemDto.getQuantity();

            orderItems.add(orderItem);
        }

        order.setOrderItem(orderItems);
        order.setTotAmount(totalAmount);

        Order savedOrder = orderRepository.save(order);

        return OrderMapper.toDTO(savedOrder);
    }

    @Override
    public OrderDTO getOrderById(Long orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        return OrderMapper.toDTO(order);
    }

    @Override
    public List<OrderDTO> getAllOrders() {

        List<Order> orders = orderRepository.findAll();

        return orders.stream()
                .map(OrderMapper::toDTO)
                .toList();
    }
    @Override
    public List<OrderDTO> getOrdersByUserId(Long userId) {

        List<Order> orders = orderRepository.findByUserId(userId);

        return orders.stream()
                .map(OrderMapper::toDTO)
                .toList();
    }

    @Override
    public void cancelOrder(Long orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(Order.OrderStatus.CANCELLED);

        orderRepository.save(order);
    }
}