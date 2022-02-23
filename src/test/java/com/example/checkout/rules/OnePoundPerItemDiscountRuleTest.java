package com.example.checkout.rules;

import com.example.checkout.BaseTest;
import com.example.checkout.model.Item;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OnePoundPerItemDiscountRuleTest extends BaseTest {

    private final PromotionRule rule = new OnePoundPerItemDiscount();

    @Test
    public void calculate_discount_positive_path() {
        //given
        List<Item> items = Stream.of(ITEM_2, ITEM_2).collect(Collectors.toList());
        BigDecimal numberOfItems = BigDecimal.valueOf(2);
        BigDecimal originalPrice = ITEM_2.getProductPrice().add(ITEM_2.getProductPrice());

        //when
        BigDecimal totalPrice = rule.apply(items);

        //then
        Assert.assertEquals(originalPrice.subtract(numberOfItems), totalPrice);
    }
}
