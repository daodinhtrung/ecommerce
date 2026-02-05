package com.example.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController // Đánh dấu đây là nơi nhận Request API
@RequestMapping("/api/products") // Đường dẫn chung: http://localhost:8080/api/products
public class ProductController {

    @Autowired // Tiêm (Inject) Repository vào để dùng
    private ProductRepository productRepository;

    // 1. API Lấy danh sách sản phẩm (GET)
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // 2. API Thêm sản phẩm mới (POST)
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        // @RequestBody: Chuyển JSON từ người dùng gửi lên thành Object Java
        return productRepository.save(product);
    }
}