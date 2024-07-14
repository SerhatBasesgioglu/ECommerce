package com.aydakar.ecommerce.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aydakar.ecommerce.dto.CategoryRequestDto;
import com.aydakar.ecommerce.dto.CategoryResponseDto;
import com.aydakar.ecommerce.entity.Category;
import com.aydakar.ecommerce.service.CategoryService;

@RestController
@RequestMapping("categories")
public class CategoryController {
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public CategoryController(CategoryService categoryService, ModelMapper modelMapper) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("")
    public List<CategoryResponseDto> getAllCategories() {
        List<Category> categoryList = categoryService.getAllCategories();
        List<CategoryResponseDto> response = categoryList.stream()
                .map(category -> modelMapper.map(category, CategoryResponseDto.class))
                .collect(Collectors.toList());
        return response;
    }

    @GetMapping("{id}")
    public CategoryResponseDto getCategoryById(@PathVariable Long id) {
        Category category = categoryService.findCategoryById(id);
        return modelMapper.map(category, CategoryResponseDto.class);
    }

    @PostMapping("")
    public CategoryResponseDto createCategory(@RequestBody CategoryRequestDto categoryRequestDto) {
        Category category = modelMapper.map(categoryRequestDto, Category.class);
        Category savedCategory = categoryService.createCategory(category);
        return modelMapper.map(savedCategory, CategoryResponseDto.class);
    }

    @DeleteMapping("{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
