package com.example.App.controller;

import org.hibernate.procedure.ProcedureOutputs;
import org.springframework.web.bind.annotation.RestController;
import com.example.App.entity.ProductVariants;
import com.example.App.service.ProductVariantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductVariantsController {
    @Autowired private ProductVariantsService productVariantsService;

    @PostMapping("/productVariants")
    public ProductVariants saveProductVariants(@RequestBody ProductVariants productVariants) {
        return productVariantsService.saveProductVariants(productVariants);
    }

    // Fetch all the items present in the product variants table
    @GetMapping("/productVariants/all")
    public List<ProductVariants> fetchAllProductVariants() {
        return productVariantsService.fetchAllProductVariants();
    }

    // Fetch the product variant with particular id
    @GetMapping("/productVariants/{id}")
    public Optional<ProductVariants> fetchProductVariantById(@PathVariable("id") Long productVariantId) {
        return productVariantsService.fetchProductVariantById(productVariantId);
    }

    // Fetch all the product variants for given products with product id
    @GetMapping("/productVariantsAll/{id}")
    public List<ProductVariants> fetchProductVariantsListByProductId(@PathVariable("id") Long productId) {
        return productVariantsService.fetchProductVariantsListByProductId(productId);
    }

    // Edit an item in product variants table with particular product variant id
    @PutMapping("/productVariants/{id}")
    public ProductVariants updateProductVariant(@RequestBody ProductVariants productVariants, @PathVariable("id") Long productVariantId) {
        return productVariantsService.updateProductVariant(productVariants, productVariantId);
    }

    // Delete an item with given product variant id
    @DeleteMapping("/productVariants/{id}")
    public String deleteProductVariantsById(@PathVariable("id") Long productVariantsId) {
        productVariantsService.deleteProductVariantsById(productVariantsId);
        return "Delete Operation on product variants is successful!";
    }
}
