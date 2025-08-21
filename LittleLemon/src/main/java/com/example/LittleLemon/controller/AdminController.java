package com.example.LittleLemon.controller;

import com.example.LittleLemon.dto.CategoryCreateDto;
import com.example.LittleLemon.dto.CategoryResponseDto;
import com.example.LittleLemon.dto.ProductCreateDto;
import com.example.LittleLemon.dto.ProductResponseDto;
import com.example.LittleLemon.service.CategoryService;
import com.example.LittleLemon.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("caffe/admin")
public class AdminController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @GetMapping("/b")
    public String showMessage(){
        return "Hi LittleLemonApp";
    }

    @PostMapping("/category")
    public ResponseEntity<CategoryResponseDto> addCategory(@RequestBody CategoryCreateDto categoryCreateDto){

        CategoryResponseDto categoryResponseDto = categoryService.createCategory(categoryCreateDto);

        return ResponseEntity.ok(categoryResponseDto);

    }

    @GetMapping("/category")
    public ResponseEntity<List<CategoryResponseDto>> getCategories(){

        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/product")
    public ResponseEntity<List<ProductResponseDto>> getProducts(){

        return ResponseEntity.ok(productService.getAllProduct());


    }

    @PostMapping("/product/{categoryId}")
    public ResponseEntity<ProductResponseDto> addProduct(@PathVariable Long categoryId,@RequestBody ProductCreateDto productCreateDto){
        return ResponseEntity.ok(productService.addProduct(categoryId,productCreateDto));
    }

    @GetMapping("/product/{categoryId}")
    public ResponseEntity<List<ProductResponseDto>> getProductsByCategory(@PathVariable Long categoryId){

        return ResponseEntity.ok(productService.getAllProductsByCategory(categoryId));
    }

}
