package com.example.checkout.rules;

import com.example.checkout.model.Item;

import java.math.BigDecimal;
import java.util.List;

public class OnePoundPerItemDiscount extends BaseRule implements PromotionRule {

    @Override
    public BigDecimal apply(List<Item> items) {

        validateInputData(items);

        BigDecimal totalPrice = calculateTotalPrice(items);
        BigDecimal discount = calculateDiscount(items);

        return applyDiscount(totalPrice, discount);
    }

    private BigDecimal calculateDiscount(List<Item> items) {
        return BigDecimal.valueOf(items.size());
    }

}
