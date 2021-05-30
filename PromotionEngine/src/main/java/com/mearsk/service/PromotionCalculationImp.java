package com.mearsk.service;

import com.mearsk.pojo.Product;
import com.mearsk.pojo.Promotion;

import java.util.List;

public class PromotionCalculationImp implements PromotionCalculationInterface{

    @Override
    public int promotionCalculation(Product product, List<Promotion> promotionList) {
        int totalPrice = 0;
        for (Promotion promotion: promotionList) {
            if (promotion.getProductId() == product.getProductId()) {
                totalPrice = product.getProductCount() / promotion.getPromotionAvailableNumber() * promotion.getPromotionPrice() +
                        product.getProductCount() %  promotion.getPromotionAvailableNumber() * product.getProductPrice();
            }
        }

        return totalPrice;
    }
}
