package com.example.ecommerce;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Quan hệ 1-N: Một Category chứa list các Product
    // "mappedBy" trỏ tới tên biến 'category' bên file Product (sắp sửa)
    // @JsonIgnore để tránh lỗi vòng lặp vô tận khi chuyển sang JSON (Category -> Product -> Category...)
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}