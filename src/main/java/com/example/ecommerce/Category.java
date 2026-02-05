package com.example.ecommerce;

import jakarta.persistence.*;
import lombok.Data; // Hoặc dùng @Getter, @Setter nếu không muốn dùng @Data
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "category")
    @JsonIgnore 
    private List<Product> products;
}