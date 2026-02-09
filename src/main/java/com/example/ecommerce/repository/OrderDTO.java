package com.example.ecommerce.repository;
import java.util.List;

import lombok.Data;

@Data
public class OrderDTO {
    private List<CartItem> items;
    @Data
    public static class CartItem {
        private Long productId;
        private Integer quantity;
    }
}