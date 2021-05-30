package com.mearsk.service;

import com.mearsk.pojo.Product;
import com.mearsk.pojo.Promotion;

import java.util.List;

public class TotalCartAmount {
    int totalCartPrice = 0;
    PromotionCalculationImp promotionCalculationImp = new PromotionCalculationImp();

    public int totalCartAmount(List<Product> productlist, List<Promotion> promotionList) {
        for(Product product : productlist) {
            if (!product.getCombinationPromotionAvailable()) {
                totalCartPrice = totalCartPrice + promotionCalculationImp.promotionCalculation(product, promotionList);
            }
        }
        return totalCartPrice;
    }


}
