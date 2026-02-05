package com.example.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service // Đánh dấu đây là nơi xử lý nghiệp vụ
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository; // Cần cái này để tra giá sản phẩm

    public Order createOrder(OrderDTO orderDTO) {
        Order order = new Order();
        List<OrderItem> orderItems = new ArrayList<>();
        double total = 0;

        // Duyệt qua danh sách khách gửi lên
        for (OrderDTO.CartItem itemDTO : orderDTO.getItems()) {
            // 1. Tìm sản phẩm trong kho
            Product product = productRepository.findById(itemDTO.getProductId())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm ID: " + itemDTO.getProductId()));

            // 2. Tạo chi tiết đơn hàng
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setQuantity(itemDTO.getQuantity());
            orderItem.setPrice(product.getPrice()); // Lấy giá hiện tại của SP
            orderItem.setOrder(order); // Gắn vào đơn hàng cha

            // 3. Cộng dồn tổng tiền
            total += product.getPrice() * itemDTO.getQuantity();
            
            orderItems.add(orderItem);
        }

        // 4. Set dữ liệu cho đơn hàng cha
        order.setTotalPrice(total);
        order.setOrderItems(orderItems);

        // 5. Lưu vào DB (Nhờ CascadeType.ALL, nó sẽ lưu luôn cả OrderItems)
        return orderRepository.save(order);
    }
}