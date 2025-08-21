package com.example.LittleLemon.controller;

import com.example.LittleLemon.service.CategoryService;
import com.example.LittleLemon.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("caffe/admin")
public class AdminController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

}
