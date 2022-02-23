package com.example.checkout.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@EqualsAndHashCode
public class Item {

    private BigDecimal productPrice;

    private String productCode;

    private String productName;
}
