package com.example.ecommercebackendapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    private Double tot_Amount;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItem;

    private OrderStatus status;

//    @Enumerated(EnumType.STRING)
    public enum OrderStatus{
        PENDING,
        SHIFTED,
        DELIVERED,
        CANCELLED
    }

}
