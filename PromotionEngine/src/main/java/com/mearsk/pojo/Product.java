package com.mearsk.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private Integer productId;
    private String productName;
    private Integer productCount;
    private Integer productPrice;
    private Boolean combinationPromotionAvailable;
}
