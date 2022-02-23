package com.example.checkout.model;

import com.example.checkout.rules.PromotionRule;
import com.example.checkout.rules.impl.NoDiscountRule;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Checkout {

    private final PromotionRule strategy;

    private final List<Item> items = new ArrayList<>();

    public Checkout() {
        this.strategy = new NoDiscountRule();
    }

    public Checkout(final PromotionRule strategy) {
        this.strategy = Optional.ofNullable(strategy)
                .orElse(new NoDiscountRule());
    }

    public void scan(final Item item) {
        this.items.add(item);
    }

    public BigDecimal total() {
        this.strategy.validateInputData(this.items);
        return this.strategy.apply(this.items);
    }
}
