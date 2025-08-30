package com.example.LittleLemon.service;

import com.example.LittleLemon.dto.CategoryCreateDto;
import com.example.LittleLemon.dto.CategoryResponseDto;
import com.example.LittleLemon.exception.CategoryAlreadyExistsException;
import com.example.LittleLemon.model.Category;
import com.example.LittleLemon.repository.CategoryRepository;
import com.example.LittleLemon.repository.ProductRepository;
import com.example.LittleLemon.utility.CategoryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private  static final Logger logger = LoggerFactory.getLogger(CategoryService.class);

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    public CategoryResponseDto createCategory(CategoryCreateDto categoryCreateDto){

        categoryRepository.findByName(categoryCreateDto.getName()).ifPresent(c->{
            logger.warn("Category {} Already Exists", categoryCreateDto.getName());
                throw new CategoryAlreadyExistsException("Category Already Exists");});

        Category category = null;
        try {
            category = categoryRepository.save(CategoryMapper.toEntity(categoryCreateDto));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        CategoryResponseDto categoryResponseDto = CategoryMapper.toResponseDto(category);
        logger.info("Category Successfully added }{}", categoryResponseDto);

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
