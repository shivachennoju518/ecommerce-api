//package com.example.ecommercebackendapi.config;
//
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@EnableWebSecurity
//@EnableMethodSecurity
//public class SecurityConfig {
//
//
//
//    public SecurityFilterChain httpSecurity(HttpSecurity security){
//
//        return security
//                .authorizeHttpRequests(
//                        auth->auth.requestMatchers(
//                        "/api/v1/user/**"
//                ).permitAll()
//                )
//                .cors(AbstractHttpConfigurer::disable)
//                .formLogin(AbstractHttpConfigurer::disable)
//                .addFilterBefore(
//                        UsernamePasswordAuthenticationFilter.class,
//                )
//                .build();
//    }
//}
