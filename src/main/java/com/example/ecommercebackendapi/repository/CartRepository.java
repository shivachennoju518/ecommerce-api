package com.example.ecommercebackendapi.repository;

import com.example.ecommercebackendapi.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}
