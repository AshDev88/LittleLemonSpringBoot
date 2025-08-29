package com.example.LittleLemon.service;

import com.example.LittleLemon.dto.CartRequestDto;
import com.example.LittleLemon.model.CartItem;
import com.example.LittleLemon.model.Product;
import com.example.LittleLemon.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    ProductRepository productRepository;

    public String addToCart(CartRequestDto cartRequestDto){
        for(CartItem item: cartRequestDto.getItems()){
            Product product= productRepository.findById(item.getId()).orElseThrow(()-> new RuntimeException("Product not Found!"));

            if (item.getQuantity()>product.getQuantity()){
                return  "Not enough in stock" + product.getName();
            }

            product.setQuantity(product.getQuantity()- item.getQuantity());
            productRepository.save(product);
        }
        return "Product added to Cart";
    }
}
