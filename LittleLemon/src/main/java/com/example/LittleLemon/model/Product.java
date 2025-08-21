package com.example.LittleLemon.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String imageUrl;

    private double price;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;

    public Product() {
    }

    public Product(Long id, String name, String description,String imageUrl, double price, int quantity, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl=imageUrl;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public Product(String name, String description,String imageUrl, double price, int quantity, Category category) {
        this.name = name;
        this.description = description;
        this.imageUrl=imageUrl;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
