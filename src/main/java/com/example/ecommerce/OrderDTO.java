package com.example.ecommerce;
import lombok.Data;
import java.util.List;

@Data
public class OrderDTO {
    private List<CartItem> items;
    @Data
    public static class CartItem {
        private Long productId;
        private Integer quantity;
    }
}