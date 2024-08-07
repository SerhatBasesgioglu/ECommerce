package com.aydakar.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aydakar.ecommerce.entity.Category;
import com.aydakar.ecommerce.exception.ResourceNotFoundException;
import com.aydakar.ecommerce.repository.CategoryRepository;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return (List<Category>) categoryRepository.findAll();
    }

    public Category findCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("This category does not exist: " + id));
    }

    public Category getCategoryByName(String name) {
        return categoryRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("This category does not exist: " + name));
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public void validateCategory(Long categoryId) {
        findCategoryById(categoryId);
    }
}
