package com.example.ecommercebackendapi.mapper;

import com.example.ecommercebackendapi.dto.CartItemDTO;
import com.example.ecommercebackendapi.dto.CartResponseDTO;
import com.example.ecommercebackendapi.entity.Cart;
import com.example.ecommercebackendapi.entity.CartItem;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartMapper {
    public static CartItemDTO toCartItemDTO(CartItem cartItem) {

        CartItemDTO dto = new CartItemDTO();

        dto.setProductId(cartItem.getProduct().getId());
        dto.setProductName(cartItem.getProduct().getName());
        dto.setPrice(cartItem.getProduct().getPrice());
        dto.setQuantity(cartItem.getQuantity());
        dto.setSubTotal((cartItem.getQuantity() != null ? cartItem.getQuantity() : 1) * ( cartItem.getProduct().getPrice() != null ? cartItem.getProduct().getPrice(): 0  ));

        return dto;
    }

    public static CartResponseDTO toCartResponseDTO(Cart cart) {

        CartResponseDTO dto = new CartResponseDTO();

        dto.setUserId(cart.getUser().getId());

        List<CartItemDTO> items = cart.getCartItem()
                .stream()
                .map(CartMapper::toCartItemDTO)
                .collect(Collectors.toList());
dto.setTotalPrice(      items.stream()
        .mapToDouble(CartItemDTO::getSubTotal)
        .sum() );
        dto.setItems(items);

        return dto;
    }
}
