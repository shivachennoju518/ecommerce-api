package com.example.ecommercebackendapi.service;

import com.example.ecommercebackendapi.entity.User;
import com.example.ecommercebackendapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public @NonNull UserDetails loadUserByUsername(@NonNull  String email) throws UsernameNotFoundException {
         User user = userRepository.getByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return new com.example.ecommercebackendapi.config.UserDetails(user);
    }
}
