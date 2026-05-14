package com.example.ecommercebackendapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private double price;
    private int stock;
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

   @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<OrderItem> orderItem;

   @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<CartItem> cartItem;

}
