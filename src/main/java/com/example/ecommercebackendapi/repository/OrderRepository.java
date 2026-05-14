package com.example.ecommercebackendapi.repository;

import com.example.ecommercebackendapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
