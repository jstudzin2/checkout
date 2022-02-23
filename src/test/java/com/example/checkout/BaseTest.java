package com.example.checkout;

import com.example.checkout.model.Item;

import java.math.BigDecimal;

public class BaseTest {

    protected static final Item ITEM_1 = Item.builder().productCode("001").productName("T-shirt").productPrice(BigDecimal.valueOf(9.25d)).build();
    protected static final Item ITEM_2 = Item.builder().productCode("002").productName("Shoes").productPrice(BigDecimal.valueOf(45)).build();
    protected static final Item ITEM_3 = Item.builder().productCode("003").productName("Trousers").productPrice(BigDecimal.valueOf(19.95d)).build();
    protected static final Item ITEM_4 = Item.builder().productCode("003").productName("Trousers").build();

}
