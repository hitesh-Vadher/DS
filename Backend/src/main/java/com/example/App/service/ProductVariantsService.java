package com.example.App.service;

import com.example.App.entity.ProductVariants;
import java.util.List;
import java.util.Optional;

public interface ProductVariantsService {
    ProductVariants saveProductVariants(ProductVariants productVariants);

    List <ProductVariants> fetchAllProductVariants();

    Optional<ProductVariants> fetchProductVariantById(Long productVariantId);

    List <ProductVariants> fetchProductVariantsListByProductId(Long productId);

    ProductVariants updateProductVariant(ProductVariants productVariants, Long productVariantId);

    void deleteProductVariantsById(Long productVariantsId);
}
