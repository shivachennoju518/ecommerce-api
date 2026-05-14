package com.example.ecommercebackendapi.repository;

import com.example.ecommercebackendapi.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
