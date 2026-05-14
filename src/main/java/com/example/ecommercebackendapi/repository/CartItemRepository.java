package com.example.ecommercebackendapi.repository;

import com.example.ecommercebackendapi.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
}
