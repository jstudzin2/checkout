package com.example.checkout.rules.impl;

import com.example.checkout.model.Item;
import com.example.checkout.rules.PromotionRule;

import java.math.BigDecimal;
import java.util.List;

public class NoDiscountRule extends BaseRule implements PromotionRule {

    @Override
    public BigDecimal apply(List<Item> items) {
        return calculateTotalPrice(items);
    }
}
