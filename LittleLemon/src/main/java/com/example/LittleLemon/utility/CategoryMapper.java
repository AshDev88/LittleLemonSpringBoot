package com.example.LittleLemon.utility;

import com.example.LittleLemon.dto.CategoryCreateDto;
import com.example.LittleLemon.dto.CategoryResponseDto;
import com.example.LittleLemon.model.Category;

public class CategoryMapper {

    public static Category toEntity(CategoryCreateDto categoryCreateDto){

        String categoryName = categoryCreateDto.getName().substring(0,1).toUpperCase()+categoryCreateDto.getName().substring(1).toLowerCase();


        return new Category(categoryName, categoryCreateDto.isAvailable());
    }

    public static CategoryResponseDto toResponseDto(Category category){

        return new CategoryResponseDto(category.getId(), category.getName(), category.isAvailable(),category.getProducts());
    }
}
