package com.example.App.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ProductVariants {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productVariantsId;
    private String sku;
    private String productVariantName;
    private Long productId;
    private String imageURL1;
    private String imageURL2;
    private String imageURL3;
    private Long quantity;
    private Long price;
}
