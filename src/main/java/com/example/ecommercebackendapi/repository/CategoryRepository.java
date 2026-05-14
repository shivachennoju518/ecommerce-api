package com.example.ecommercebackendapi.repository;

import com.example.ecommercebackendapi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
