package com.example.App.service;

import com.example.App.entity.Category;
import com.example.App.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> fetchCategoryList() {
        return (List<Category>)categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        Category categoryDB = categoryRepository.findById(categoryId).get();

        if(Objects.nonNull(category.getCategoryName()) && !"".equalsIgnoreCase(category.getCategoryName())) {
            categoryDB.setCategoryName(category.getCategoryName());
        }

        return categoryRepository.save(categoryDB);
    }

    @Override
    public void deleteCategoryById(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

}