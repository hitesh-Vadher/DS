package com.example.myapplication.model;

public class ProductModel {
    private Long productId;

    private String productName;
    private String productDescription;
    private Long productCategoryId;

    public ProductModel(Long productId, String productName, String productDescription, Long productCategoryId) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCategoryId = productCategoryId;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return this.productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Long getProductCategoryId() {
        return this.productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }
}
