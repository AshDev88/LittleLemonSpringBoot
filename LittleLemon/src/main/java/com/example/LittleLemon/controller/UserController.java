package com.example.LittleLemon.controller;

import com.example.LittleLemon.dto.CategoryResponseDto;
import com.example.LittleLemon.service.CategoryService;
import com.example.LittleLemon.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/caffe/user")
public class UserController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @GetMapping("/a")
    public String getMessage(){
        return "LittleLemonCaffe";
    }

    @GetMapping("/category")
    public ResponseEntity<List<CategoryResponseDto>> getCategory(){

        return ResponseEntity.ok(categoryService.getAllCategories());

    }

}
