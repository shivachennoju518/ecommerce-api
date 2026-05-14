package com.example.ecommercebackendapi.repository;

import com.example.ecommercebackendapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
