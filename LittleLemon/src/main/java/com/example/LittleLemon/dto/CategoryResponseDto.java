package com.example.LittleLemon.dto;

import com.example.LittleLemon.model.Product;

import java.util.List;

public class CategoryResponseDto {

    private Long id;

    private String name;

    private boolean available;

    private List<Product> products;

    public CategoryResponseDto(Long id, String name, boolean available, List<Product> products) {
        this.id = id;
        this.name = name;
        this.available = available;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
