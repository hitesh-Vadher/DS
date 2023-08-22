package com.example.App.service;
import com.example.App.entity.Product;
import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);

    List<Product> fetchProductList();

    List<Product> fetchProductListByProductCategoryId(Long productCategoryId);

    Product updateProduct(Product product, Long productId);

    void deleteProductById(Long productId);

    void deleteAllProducts();
}