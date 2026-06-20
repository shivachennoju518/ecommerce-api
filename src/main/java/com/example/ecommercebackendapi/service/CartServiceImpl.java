package com.example.ecommercebackendapi.service;

import com.example.ecommercebackendapi.dto.CartResponseDTO;
import com.example.ecommercebackendapi.entity.Cart;
import com.example.ecommercebackendapi.entity.CartItem;
import com.example.ecommercebackendapi.entity.Product;
import com.example.ecommercebackendapi.entity.User;
import com.example.ecommercebackendapi.mapper.CartMapper;
import com.example.ecommercebackendapi.repository.CartRepository;
import com.example.ecommercebackendapi.repository.ProductRepository;
import com.example.ecommercebackendapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;


    @Override
    public CartResponseDTO getCartByUserId(Long userId) {
        return CartMapper.toCartResponseDTO(getUserById(userId));
    }

    private Cart getUserById(Long userId){

        User user =userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
     return   cartRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
    }


    @Override
    public CartResponseDTO addProductToCart(Long userId, Long productId, int quantity) {

        User user =  userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

           Cart cart=    cartRepository.findByUser(user).orElseGet(()-> {
                  Cart newwCart= new Cart();
                   newwCart.setUser(user);
                           return cartRepository.save(newwCart);
                       }
               );

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        Optional<CartItem> existingItem = cart.getCartItem()!= null? cart.getCartItem()
                .stream()
                .filter(item -> item != null
                        && item.getProduct() != null
                        && item.getProduct().getId().equals(productId))
                .findFirst() : Optional.empty();

        if (existingItem.isPresent()) {
            CartItem item = existingItem.get();
            item.setQuantity(item.getQuantity() + quantity);
        } else {
            CartItem newItem = new CartItem();
            newItem.setCart(cart);
            newItem.setProduct(product);
            newItem.setQuantity(quantity);

            if (cart.getCartItem() == null) {
                cart.setCartItem(new ArrayList<>());
            }
            cart.getCartItem().add(newItem);
        }

        cartRepository.save(cart);

        return CartMapper.toCartResponseDTO(cart);
    }

    @Override
    public CartResponseDTO removeProductFromCart(Long userId, Long productId) {

        Cart cart = getUserById(userId);

        cart.getCartItem().removeIf(
                item -> item.getProduct().getId().equals(productId)
        );

        cartRepository.save(cart);

        return CartMapper.toCartResponseDTO(cart);
    }

    @Override
    public void clearCart(Long userId) {

        User user =userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        cartRepository.deleteByUser(user);
    }
}

