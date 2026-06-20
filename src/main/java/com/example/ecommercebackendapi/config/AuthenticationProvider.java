//package com.example.ecommercebackendapi.config;
//
//import lombok.RequiredArgsConstructor;
//import org.jspecify.annotations.Nullable;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class AuthenticationProvider implements org.springframework.security.authentication.AuthenticationProvider {
//
//    private final UserDetails userDetails;
//    @Override
//    public @Nullable Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        return new UsernamePasswordAuthenticationToken(
//               userDetails,null,userDetails.getAuthorities()
//        );
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return false;
//    }
//}
