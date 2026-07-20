package com.example.ecommercebackendapi.service;


import com.example.ecommercebackendapi.dto.LoginRequest;
import com.example.ecommercebackendapi.dto.LoginResponse;
import com.example.ecommercebackendapi.dto.UserRegisterDTO;
import com.example.ecommercebackendapi.dto.UserResponseDTO;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface UserService {
    LoginResponse login(LoginRequest request);
    UserResponseDTO registerUser(UserRegisterDTO dto);

    UserResponseDTO getUserById(Authentication authentication, Long id);



    List<UserResponseDTO> getAllUsers();

    UserResponseDTO updateUser(Long id, UserRegisterDTO dto);

    void deleteUser(Long id);
}
