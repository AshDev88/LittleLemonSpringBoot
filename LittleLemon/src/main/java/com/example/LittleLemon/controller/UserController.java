package com.example.LittleLemon.controller;

import com.example.LittleLemon.service.CategoryService;
import com.example.LittleLemon.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/caffe")
public class UserController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @GetMapping("/a")
    public String getMessage(){
        return "LittleLemonCaffe";
    }

}
