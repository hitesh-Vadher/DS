package com.example.App.controller;

import com.example.App.entity.Category;
import com.example.App.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    // Add new categories in the table
    @PostMapping("/categories")
    public Category saveCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    // Fetch all the categories from the table
    @GetMapping("/categories")
    public List<Category> fetchProductList() {
        return categoryService.fetchCategoryList();
    }

    // Update particular category with category id
    @PutMapping("/categories/{id}")
    public Category updateProduct(@RequestBody Category category, @PathVariable("id") Long categoryId) {
        return categoryService.updateCategory(category, categoryId);
    }

    // Delete particular category with given category id
    @DeleteMapping("categories/{id}")
    public String deleteProductById(@PathVariable("id") Long categoryId) {
        categoryService.deleteCategoryById(categoryId);
        return "Delete Operation Successful!";
    }
}


