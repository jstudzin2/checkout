package com.example.checkout.rules.impl;

import com.example.checkout.model.Item;
import com.example.checkout.rules.PromotionRule;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class DiscountRule extends BaseRule implements PromotionRule {

    public static final BigDecimal DISCOUNT_TRESHOLD = BigDecimal.valueOf(60);
    public static final BigDecimal DISCOUNT_PERCENTAGE = BigDecimal.valueOf(0.1d);

    @Override
    public BigDecimal apply(List<Item> items) {

        BigDecimal totalPrice = calculateTotalPrice(items);

        if (totalPrice.compareTo(DISCOUNT_TRESHOLD) > 0) {
            BigDecimal discount = calculateDiscount(totalPrice);
            return applyDiscount(totalPrice, discount);
        }
        return totalPrice;
    }

    private BigDecimal calculateDiscount(BigDecimal totalPrice) {
        return totalPrice.multiply(DISCOUNT_PERCENTAGE).setScale(2, RoundingMode.HALF_UP);
    }
}
