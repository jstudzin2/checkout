package com.example.checkout.rules.impl;

import com.example.checkout.model.Item;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class BaseRule {

    protected BigDecimal calculateTotalPrice(List<Item> items) {
        return Stream.of(items)
                .flatMap(Collection::stream)
                .map(Item::getProductPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    protected BigDecimal applyDiscount(BigDecimal totalPrice, BigDecimal discount) {
        return totalPrice.subtract(discount);
    }

    protected void validateInputData(List<Item> items) {
        Stream.of(items)
                .flatMap(Collection::stream)
                .map(Item::getProductPrice).forEach(price -> {
                    if (price == null || price.compareTo(BigDecimal.ZERO) < 0) {
                        throw new IllegalArgumentException();
                    }
                });
    }
}
