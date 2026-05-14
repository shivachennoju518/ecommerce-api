package com.example.ecommercebackendapi.repository;

import com.example.ecommercebackendapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
