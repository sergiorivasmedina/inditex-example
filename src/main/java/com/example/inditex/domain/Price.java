package com.example.inditex.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Price {
    private Long brandId;
    private String startDate;
    private String endDate;
    private Long priceList;
    private String productId;
    private Integer priority;
    private Double price;
    private String currency;
}
