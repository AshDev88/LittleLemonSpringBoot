package com.example.LittleLemon.repository;

import com.example.LittleLemon.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
