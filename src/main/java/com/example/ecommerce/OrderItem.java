package com.example.ecommerce;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;
    private Double price; // Lưu giá tại thời điểm mua (đề phòng sau này giá sp thay đổi)

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonIgnore 
    private Order order;
    // Liên kết với Product để biết là mua cái gì
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}