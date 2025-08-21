package com.example.LittleLemon.service;

import com.example.LittleLemon.repository.CategoryRepository;
import com.example.LittleLemon.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;
}
