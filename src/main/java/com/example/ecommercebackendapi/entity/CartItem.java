package com.example.ecommercebackendapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="cart_id")
    private Cart cart;
@ManyToOne
@JoinColumn(name="product_id")
    private Product product;

    private int quantity;
}
