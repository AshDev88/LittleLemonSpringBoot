package com.example.LittleLemon.service;

import com.example.LittleLemon.repository.CategoryRepository;
import com.example.LittleLemon.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;
}
