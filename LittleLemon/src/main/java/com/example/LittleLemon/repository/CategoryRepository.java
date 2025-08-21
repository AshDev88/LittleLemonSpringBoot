package com.example.LittleLemon.repository;

import com.example.LittleLemon.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
