package com.example.LittleLemon.service;

import com.example.LittleLemon.dto.CategoryCreateDto;
import com.example.LittleLemon.dto.CategoryResponseDto;
import com.example.LittleLemon.model.Category;
import com.example.LittleLemon.repository.CategoryRepository;
import com.example.LittleLemon.repository.ProductRepository;
import com.example.LittleLemon.utility.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    public CategoryResponseDto createCategory(CategoryCreateDto categoryCreateDto){

        Category category = categoryRepository.save(CategoryMapper.toEntity(categoryCreateDto));

        CategoryResponseDto categoryResponseDto = CategoryMapper.toResponseDto(category);

        return categoryResponseDto;



    }

    public List<CategoryResponseDto> getAllCategories(){
        List<Category> categoriesList =  categoryRepository.findAll();
        List<CategoryResponseDto> categoryResponseDtoList = new ArrayList<>();

        for(Category c: categoriesList){
            CategoryResponseDto categoryResponseDto = CategoryMapper.toResponseDto(c);
            categoryResponseDtoList.add(categoryResponseDto);
        }

        return categoryResponseDtoList;

    }
}
