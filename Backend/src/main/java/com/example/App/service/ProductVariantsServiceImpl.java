package com.example.App.service;

import com.example.App.entity.Product;
import com.example.App.entity.ProductVariants;
import com.example.App.repository.ProductVariantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class ProductVariantsServiceImpl implements ProductVariantsService{
    @Autowired
    private ProductVariantsRepository productVariantsRepository;

    @Override
    public ProductVariants saveProductVariants(ProductVariants productVariants) {
        return productVariantsRepository.save(productVariants);
    }

    @Override
    public List<ProductVariants> fetchAllProductVariants() {
        return productVariantsRepository.findAll();
    }

    @Override
    public Optional<ProductVariants> fetchProductVariantById(Long productVariantId) {
        return productVariantsRepository.findById(productVariantId);
    }

    @Override
    public List<ProductVariants> fetchProductVariantsListByProductId(Long productId) {
        List <ProductVariants> prodVariantsList = (List <ProductVariants>)productVariantsRepository.findAll();
        List <ProductVariants> myProdList = new ArrayList<ProductVariants>();
        for (ProductVariants product : prodVariantsList) {
            if (Objects.equals(product.getProductId(), productId)) {
                myProdList.add(product);
            }
        }
        return myProdList;
    }

    @Override
    public ProductVariants updateProductVariant(ProductVariants productVariants, Long productVariantId) {
        ProductVariants prodDB = productVariantsRepository.findById(productVariantId).get();

        if(Objects.nonNull(productVariants.getProductVariantName())) {
            prodDB.setProductVariantName(productVariants.getProductVariantName());
        }

        if(Objects.nonNull(productVariants.getImageURL1())) {
            prodDB.setImageURL1(productVariants.getImageURL1());
        }

        if(Objects.nonNull(productVariants.getImageURL2())) {
            prodDB.setImageURL2(productVariants.getImageURL2());
        }

        if(Objects.nonNull(productVariants.getImageURL3())) {
            prodDB.setImageURL3(productVariants.getImageURL3());
        }

        if(Objects.nonNull(productVariants.getSku())) {
            prodDB.setSku(productVariants.getSku());
        }

        if(Objects.nonNull(productVariants.getQuantity())) {
            prodDB.setQuantity(productVariants.getQuantity());
        }

        if(Objects.nonNull(productVariants.getPrice())) {
            prodDB.setProductId(productVariants.getPrice());
        }

        return productVariantsRepository.save(prodDB);
    }

    @Override
    public void deleteProductVariantsById(Long productId) {
        productVariantsRepository.deleteById(productId);
    }

}