package com.example.LittleLemon.controller;

import com.example.LittleLemon.dto.CartRequestDto;
import com.example.LittleLemon.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("caffe/cart")
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<String> addToCart(CartRequestDto cartRequestDto){
        String result = cartService.addToCart(cartRequestDto);
        if(!result.contains("Product added to Cart")){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);

    }
}
