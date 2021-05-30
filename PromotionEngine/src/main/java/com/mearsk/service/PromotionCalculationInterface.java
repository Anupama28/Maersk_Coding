package com.mearsk.service;

import com.mearsk.pojo.Product;
import com.mearsk.pojo.Promotion;

import java.util.List;

public interface PromotionCalculationInterface {
     int promotionCalculation(Product product, List<Promotion> promotion);
}
