package com.example.ecommercebackendapi.dto;

import com.example.ecommercebackendapi.entity.User;
import lombok.Data;


@Data
public class UserResponseDTO {

    private Long id;
        private String name;
        private String email;
        private  User.Role role;
    }

