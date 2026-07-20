package com.example.ecommercebackendapi.repository;

import com.example.ecommercebackendapi.entity.User;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<@NonNull User,@NonNull Long> {
    Optional<User> getByEmail(String email);
}
