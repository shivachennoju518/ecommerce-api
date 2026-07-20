package com.example.ecommercebackendapi.mapper;

import com.example.ecommercebackendapi.dto.UserRegisterDTO;
import com.example.ecommercebackendapi.dto.UserResponseDTO;
import com.example.ecommercebackendapi.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final PasswordEncoder passwordEncoder;
    public User toEntity(UserRegisterDTO dto){
        User user=new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        return user;

    }
    public UserResponseDTO toDTO(User user) {
        UserResponseDTO dto=new UserResponseDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        return dto;
    }
}
