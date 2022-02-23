package com.example.checkout;

import com.example.checkout.model.Checkout;
import com.example.checkout.rules.impl.DiscountRule;
import com.example.checkout.rules.impl.OnePoundPerItemDiscount;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CheckoutTest extends BaseTest {

    @Test
    public void positive_scenario_1() {
        //given
        Checkout checkout = new Checkout(new DiscountRule());
        checkout.scan(ITEM_1);
        checkout.scan(ITEM_1);
        checkout.scan(ITEM_3);

        //when
        BigDecimal totalPrice = checkout.total();

        //then
        Assert.assertEquals(BigDecimal.valueOf(38.45d), totalPrice);
    }

    @Test
    public void positive_scenario_2() {
        //given
        Checkout checkout = new Checkout(new DiscountRule());
        checkout.scan(ITEM_1);
        checkout.scan(ITEM_2);
        checkout.scan(ITEM_3);

        //when
        BigDecimal totalPrice = checkout.total();

        //then
        Assert.assertEquals(BigDecimal.valueOf(66.78d), totalPrice);
    }

    @Test
    public void empty_basket_should_be_for_free() {
        //given
        Checkout checkout = new Checkout(new DiscountRule());

        //when
        BigDecimal totalPrice = checkout.total();

        //then
        Assert.assertEquals(BigDecimal.ZERO, totalPrice);
    }

    @Test
    public void when_no_strategy_is_set_default_rule_should_be_used() {
        //given
        Checkout checkout = new Checkout(null);
        checkout.scan(ITEM_1);

        //when
        BigDecimal totalPrice = checkout.total();

        //then
        Assert.assertEquals(ITEM_1.getProductPrice(), totalPrice);
    }

    @Test
    public void different_strategies_should_give_different_results() {
        //given
        Checkout checkoutOne = new Checkout(new DiscountRule());
        Checkout checkoutTwo = new Checkout(new OnePoundPerItemDiscount());
        checkoutOne.scan(ITEM_2);
        checkoutOne.scan(ITEM_2);
        checkoutTwo.scan(ITEM_2);
        checkoutTwo.scan(ITEM_2);

        //when
        BigDecimal totalPriceOne = checkoutOne.total();
        BigDecimal totalPriceTwo = checkoutTwo.total();

        //then
        Assert.assertNotEquals(totalPriceOne, totalPriceTwo);
    }


    @Test(expected = IllegalArgumentException.class)
    public void when_price_is_not_provided_exception_should_be_thrown() {
        //given
        Checkout checkout = new Checkout(null);
        checkout.scan(ITEM_4);

        //when
        checkout.total();
    }
}
