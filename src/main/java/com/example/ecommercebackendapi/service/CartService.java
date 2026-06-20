package com.example.ecommercebackendapi.service;

import com.example.ecommercebackendapi.dto.CartResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


public interface CartService {
    CartResponseDTO getCartByUserId(Long userId);

    CartResponseDTO addProductToCart( Long userId,Long productId, int quantity);

    CartResponseDTO removeProductFromCart(Long userId, Long productId);

    void clearCart(Long userId);
}
