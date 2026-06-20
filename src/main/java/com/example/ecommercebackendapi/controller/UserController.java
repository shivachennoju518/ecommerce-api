package com.example.ecommercebackendapi.controller;

import com.example.ecommercebackendapi.dto.UserRegisterDTO;
import com.example.ecommercebackendapi.dto.UserResponseDTO;
import com.example.ecommercebackendapi.service.UserService;
//import org.springframework.security.access.prepost.PreAuthorize;
import jakarta.validation.Valid;
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
//    @PreAuthorize("hasRole('ADMIN')")
    public List<UserResponseDTO> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public UserResponseDTO getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }
    @PostMapping()
    public UserResponseDTO registerUser(@Valid @RequestBody UserRegisterDTO dto){
        return userService.registerUser(dto);
    }
    @PutMapping("/{id}")
    public UserResponseDTO updateUser(@PathVariable Long id,@RequestBody UserRegisterDTO dto){
        return userService.updateUser(id,dto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

}
