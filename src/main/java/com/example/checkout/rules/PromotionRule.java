package com.example.checkout.rules;

import com.example.checkout.model.Item;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public interface PromotionRule {

    BigDecimal apply(List<Item> items);

    default void validateInputData(List<Item> items) {
        Stream.of(items)
                .flatMap(Collection::stream)
                .map(Item::getProductPrice).forEach(price -> {
                    if (price == null || price.compareTo(BigDecimal.ZERO) < 0) {
                        throw new IllegalArgumentException();
                    }
                });
    }
}
