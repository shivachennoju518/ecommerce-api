package com.example.ecommercebackendapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRegisterDTO {
    @NotBlank
    private String name;
    @Email
    private String email;
    @NotBlank
    @Size(min=6,max=9,message="password mustbe atleast 6 characters")
    private String password;
}
