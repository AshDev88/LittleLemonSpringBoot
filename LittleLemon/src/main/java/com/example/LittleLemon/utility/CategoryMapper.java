package com.example.LittleLemon.utility;

import com.example.LittleLemon.dto.CategoryCreateDto;
import com.example.LittleLemon.dto.CategoryResponseDto;
import com.example.LittleLemon.model.Category;

public class CategoryMapper {

    public static Category toEntity(CategoryCreateDto categoryCreateDto){

        return new Category(categoryCreateDto.getName(), categoryCreateDto.isAvailable());
    }

    public static CategoryResponseDto toResponseDto(Category category){

        return new CategoryResponseDto(category.getId(), category.getName(), category.isAvailable(),category.getProducts());
    }
}
