package com.example.ecommercebackendapi.service;


import com.example.ecommercebackendapi.dto.LoginRequest;
import com.example.ecommercebackendapi.dto.LoginResponse;
import com.example.ecommercebackendapi.dto.UserRegisterDTO;
import com.example.ecommercebackendapi.dto.UserResponseDTO;
import com.example.ecommercebackendapi.entity.User;
import com.example.ecommercebackendapi.mapper.UserMapper;
import com.example.ecommercebackendapi.repository.UserRepository;
import com.example.ecommercebackendapi.util.JwtUtil;
import com.sun.security.auth.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final AuthenticationManager authenticationManager;
   private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDTO registerUser(UserRegisterDTO dto) {

        User user = userMapper.toEntity(dto);

        User saved = userRepository.save(user);

        return userMapper.toDTO(saved);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .toList();
    }

    @Override
    public UserResponseDTO getUserById(Authentication authentication,Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        if(authentication.getAuthorities().stream().anyMatch(auth-> Objects.equals(auth.getAuthority(), "ROLE_ADMIN"))){
            return userMapper.toDTO(user);
        }
       else if(Objects.equals(user.getEmail(), authentication.getName())) {
           return userMapper.toDTO(user);
       }else{
           throw new AccessDeniedException("User has no permission to access this");
       }
    }



    @Override
    public UserResponseDTO updateUser(Long id, UserRegisterDTO dto) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        return userMapper.toDTO(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }




        @Override
        public LoginResponse login(LoginRequest request) {

            Authentication authentication =
                    authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    request.email(),
                                    request.password()
                            )
                    );

          UserDetails user =
                  (UserDetails) authentication.getPrincipal();

            assert user != null;
            String token = JwtUtil.generateToken(user);

            return new LoginResponse(token);
        }
    }


