package com.example.LittleLemon.service;

import com.example.LittleLemon.dto.ProductCreateDto;
import com.example.LittleLemon.dto.ProductResponseDto;
import com.example.LittleLemon.exception.ResourceNotFoundException;
import com.example.LittleLemon.model.Category;
import com.example.LittleLemon.model.Product;
import com.example.LittleLemon.repository.CategoryRepository;
import com.example.LittleLemon.repository.ProductRepository;
import com.example.LittleLemon.utility.ProductMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public List<ProductResponseDto> getAllProduct(){
        List<ProductResponseDto> productResponseDtoList = new ArrayList<>();
        List<Product>  productList = productRepository.findAll();

        for(Product product: productList){
            ProductResponseDto productResponseDto = ProductMapper.toResponseDto(product);
            productResponseDtoList.add(productResponseDto);
        }
        logger.info("Sending All Products");
        return productResponseDtoList;

    }

    public ProductResponseDto addProduct(Long categoryId, ProductCreateDto productCreateDto){
        Category category = categoryRepository.findById(categoryId).orElseThrow(()->{
                logger.warn("Category Not Found");
                return new ResourceNotFoundException("Category not Found");});
        Product product = ProductMapper.toEntity(productCreateDto,category);
        Product p = productRepository.save(product);

        logger.info("Product {} Added:{}", p.getName(), LocalDate.now());
        return ProductMapper.toResponseDto(p);
    }

    public List<ProductResponseDto> getAllProductsByCategory(Long categoryId){
        List<ProductResponseDto> productResponseDtoList = new ArrayList<>();
        List<Product> productList = productRepository.findByCategoryId(categoryId);
        if (productList.isEmpty()){
            throw new ResourceNotFoundException("Not Found!");
        }

        for(Product p: productList){
            ProductResponseDto productResponseDto = ProductMapper.toResponseDto(p);
            productResponseDtoList.add(productResponseDto);
        }
        return productResponseDtoList;


    }
}
