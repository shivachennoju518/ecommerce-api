//package com.example.ecommercebackendapi.config;
//
//import com.example.ecommercebackendapi.entity.User;
//import lombok.RequiredArgsConstructor;
//import org.jspecify.annotations.Nullable;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.stereotype.Component;
//
//import java.util.Collection;
//import java.util.List;
//@Component
//@RequiredArgsConstructor
//public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {
//    private final User user;
//
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return List.of(new SimpleGrantedAuthority("Role_"+user.getRole().name()));
//    }
//
//    @Override
//    public @Nullable String getPassword() {
//        return "";
//    }
//
//    @Override
//    public String getUsername() {
//        return user.getRole().name();
//    }
//}
