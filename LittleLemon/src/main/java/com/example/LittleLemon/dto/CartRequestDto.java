package com.example.LittleLemon.dto;

import com.example.LittleLemon.model.CartItem;

import java.util.List;

public class CartRequestDto {

    private List<CartItem> items;

    public CartRequestDto(List<CartItem> items) {
        this.items = items;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }
}
