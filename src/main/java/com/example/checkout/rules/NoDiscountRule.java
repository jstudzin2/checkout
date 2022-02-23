package com.example.checkout.rules;

import com.example.checkout.model.Item;

import java.math.BigDecimal;
import java.util.List;

public class NoDiscountRule extends BaseRule implements PromotionRule {

    @Override
    public BigDecimal apply(List<Item> items) {

        validateInputData(items);

        return calculateTotalPrice(items);
    }
}
