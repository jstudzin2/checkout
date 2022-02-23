package com.example.checkout.rules;

import com.example.checkout.model.Item;

import java.math.BigDecimal;
import java.util.List;

public interface PromotionRule {

    BigDecimal apply(List<Item> items);

}
