package com.example.App.service;

import com.example.App.entity.Category;
import com.example.App.entity.Product;

import java.util.List;

public interface CategoryService {
    Category saveCategory(Category category);

    List<Category> fetchCategoryList();

    Category updateCategory(Category category, Long categoryId);

    void deleteCategoryById(Long categoryId);
}
