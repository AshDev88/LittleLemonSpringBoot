package com.example.LittleLemon.utility;

import com.example.LittleLemon.dto.ProductCreateDto;
import com.example.LittleLemon.dto.ProductResponseDto;
import com.example.LittleLemon.model.Category;
import com.example.LittleLemon.model.Product;

public class ProductMapper {

    public static Product toEntity(ProductCreateDto productCreateDto, Category category){

        return new Product(productCreateDto.getName(), productCreateDto.getDescription(),productCreateDto.getImageUrl(),productCreateDto.getPrice(),productCreateDto.getQuantity(),category);

    }

    public static ProductResponseDto toResponseDto(Product product){

        return new ProductResponseDto(product.getId(), product.getName(), product.getDescription(), product.getImageUrl(), product.getPrice(), product.getQuantity());
    }
}
