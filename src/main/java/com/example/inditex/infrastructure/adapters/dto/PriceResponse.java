package com.example.inditex.infrastructure.adapters.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceResponse {
    private String productId;
    private Long brandId;
    private Long priceList;
    private String startDate;
    private String endDate;
    private Double price;
}
