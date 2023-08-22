package com.example.App.controller;
import com.example.App.entity.Product;
import com.example.App.service.ProductService;
import com.example.App.exception.NotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriBuilder;

@RestController
public class ProductController {
    @Autowired private ProductService productService;

    // Add a product to the catalogue.
    @PostMapping("/products")
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    // Fetch all the products in the catalogue.
    @GetMapping("/products/all")
    public List<Product> fetchProductList() {
        return productService.fetchProductList();
    }

    // Provide categoryId to fetch products of that respective category.
    @GetMapping("/products/{categoryId}")
    public List<Product> fetchProductCategoryListById(@PathVariable("categoryId") Long productCategoryId) {
        return productService.fetchProductListByProductCategoryId(productCategoryId);
    }

    // Update product by providing product id
    @PutMapping("/products/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable("id") Long productId) {
        return productService.updateProduct(product, productId);
    }

    // Remove product by id
    @DeleteMapping("products/{id}")
    public String deleteProductById(@PathVariable("id") Long productId) {
        productService.deleteProductById(productId);
        return "Delete Operation Successful!";
    }

    // Remove all the products from the catalogue
    @DeleteMapping("/products/deleteAll")
    public String deleteAllProducts() {
        productService.deleteAllProducts();
        return "Deleted all the products";
    }
}

