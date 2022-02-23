package com.example.checkout.rules;

import com.example.checkout.BaseTest;
import com.example.checkout.model.Item;
import com.example.checkout.rules.impl.DiscountRule;
import com.example.checkout.rules.impl.NoDiscountRule;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NoDiscountRuleTest extends BaseTest {

    private final PromotionRule rule = new NoDiscountRule();

    @Test
    public void no_discount_should_be_applied() {
        //given
        List<Item> items = Stream.of(ITEM_1, ITEM_2).collect(Collectors.toList());

        //when
        BigDecimal totalPrice = rule.apply(items);

        //then
        Assert.assertEquals(ITEM_1.getProductPrice().add(ITEM_2.getProductPrice()), totalPrice);

    }
}
