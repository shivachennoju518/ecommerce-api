package com.example.ecommercebackendapi.controller;

import com.example.ecommercebackendapi.dto.LoginRequest;
import com.example.ecommercebackendapi.dto.LoginResponse;
import com.example.ecommercebackendapi.dto.UserRegisterDTO;
import com.example.ecommercebackendapi.dto.UserResponseDTO;
import com.example.ecommercebackendapi.service.UserService;
//import org.springframework.security.access.prepost.PreAuthorize;
import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }
    @GetMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserResponseDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")

    public UserResponseDTO getUserById(@PathVariable Long id, Authentication authentication){
        return userService.getUserById(authentication,id);
    }

    @PostMapping("/register")
    @PreAuthorize("hasRole('ADMIN')")
    public UserResponseDTO registerUser(@Valid @RequestBody UserRegisterDTO dto){
        return userService.registerUser(dto);
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public UserResponseDTO updateUser(@PathVariable Long id,@RequestBody UserRegisterDTO dto){
        return userService.updateUser(id,dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @PostMapping("/login")
    public @NonNull ResponseEntity<@NonNull LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest){
     LoginResponse token=   userService.login(loginRequest);
     return ResponseEntity.ok(token);
    }

}
