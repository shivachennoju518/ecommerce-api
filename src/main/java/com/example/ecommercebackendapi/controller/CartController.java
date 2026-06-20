package com.example.ecommercebackendapi.controller;

import com.example.ecommercebackendapi.dto.AddToCartDTO;
import com.example.ecommercebackendapi.dto.CartResponseDTO;
import com.example.ecommercebackendapi.service.CartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;



    @GetMapping("/{userId}")
    public CartResponseDTO getCartById(@PathVariable  Long userId){
        return cartService.getCartByUserId(userId);
    }

    // Add Product to Cart
    @PostMapping("/{userId}/add")
    public CartResponseDTO addProductToCart(
            @PathVariable Long userId,
            @Valid @RequestBody AddToCartDTO dto) {

        return cartService.addProductToCart(
                userId,
               dto.getProductId(),
                dto.getQuantity()
        );
    }

    // Remove Product from Cart
    @DeleteMapping("/{userId}/remove/{productId}")
    public CartResponseDTO removeProductFromCart(
            @PathVariable Long userId,
            @PathVariable Long productId) {

        return cartService.removeProductFromCart(
                userId,
                productId
        );
    }

    // Clear Cart
    @DeleteMapping("/{userId}/clear")
    public String clearCart(@PathVariable Long userId) {

        cartService.clearCart(userId);

        return "Cart cleared successfully";
    }
}
