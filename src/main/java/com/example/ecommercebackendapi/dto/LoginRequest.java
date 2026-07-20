package com.example.ecommercebackendapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LoginRequest(
        @NotBlank(message = "Email is required")
        @Email(message = "Email need to be needed")
        String email,

        @NotBlank(message = "Password is required")
        String password
) {

    public LoginRequest {
        email = email.strip();
        password = password.strip();
    }
}
