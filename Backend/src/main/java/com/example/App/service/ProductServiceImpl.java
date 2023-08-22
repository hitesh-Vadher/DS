package com.example.App.service;

import com.example.App.entity.Product;
import com.example.App.entity.ProductVariants;
import com.example.App.repository.ProductVariantsRepository;
import com.example.App.exception.ErrorResponse;
import com.example.App.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductVariantsRepository productVariantsRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> fetchProductList() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> fetchProductListByProductCategoryId(Long productCategoryId) {
        List <Product> prodList = productRepository.findAll();
        List <Product> myProdList = new ArrayList<>();
        for (Product product : prodList) {
            if (Objects.equals(product.getProductCategoryId(), productCategoryId)) {
                myProdList.add(product);
            }
        }
        return myProdList;
    }

    @Override
    public Product updateProduct(Product product, Long productId) {
        Product prodDB = productRepository.findById(productId).get();

        if(Objects.nonNull(product.getProductName()) && !"".equalsIgnoreCase(product.getProductName())) {
            prodDB.setProductName(product.getProductName());
        }

        if(Objects.nonNull(product.getProductDescription()) && !"".equalsIgnoreCase(product.getProductDescription())) {
            prodDB.setProductDescription(product.getProductDescription());
        }

        if(Objects.nonNull(product.getProductCategoryId())) {
            prodDB.setProductCategoryId(product.getProductCategoryId());
        }

        return productRepository.save(prodDB);
    }

    //If we delete a product, all its variants should also be deleted from the product variants database.
    @Override
    public void deleteProductById(Long productId) {
        List <ProductVariants> myList = productVariantsRepository.findAll();
        for(ProductVariants tempProd: myList) {
            if(Objects.equals(tempProd.getProductId(), productId)) {
                Long prodVariantId = tempProd.getProductVariantsId();
                productVariantsRepository.deleteById(prodVariantId);

            }
        }
        productRepository.deleteById(productId);
    }

    @Override
    public void deleteAllProducts() {
        productRepository.deleteAll();
    }

}