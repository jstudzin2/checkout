package com.example.checkout.rules;

import com.example.checkout.BaseTest;
import com.example.checkout.model.Item;
import com.example.checkout.rules.impl.DiscountRule;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DiscountRuleTest extends BaseTest {

    private final PromotionRule rule = new DiscountRule();

    @Test
    public void calculate_discount_positive_path() {
        //given
        List<Item> items = Stream.of(ITEM_1, ITEM_2, ITEM_3).collect(Collectors.toList());

        //when
        BigDecimal totalPrice = rule.apply(items);

        //then
        Assert.assertEquals(BigDecimal.valueOf(66.78d), totalPrice);

    }

    @Test
    public void discount_should_not_be_applied() {
        //given
        List<Item> items = Stream.of(ITEM_1).collect(Collectors.toList());

        //when
        BigDecimal totalPrice = rule.apply(items);

        //then
        Assert.assertEquals(ITEM_1.getProductPrice(), totalPrice);

    }

    @Test(expected = IllegalArgumentException.class)
    public void when_price_is_not_provided_exception_should_be_thrown() {
        //given
        List<Item> items = Stream.of(ITEM_4).collect(Collectors.toList());

        //when
        rule.apply(items);

    }
}
