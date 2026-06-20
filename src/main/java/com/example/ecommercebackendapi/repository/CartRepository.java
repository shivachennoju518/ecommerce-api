package com.example.ecommercebackendapi.repository;

import com.example.ecommercebackendapi.entity.Cart;
import com.example.ecommercebackendapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart,Long> {

    Optional<Cart> findByUser(User user);
    void deleteByUser(User user);

}
