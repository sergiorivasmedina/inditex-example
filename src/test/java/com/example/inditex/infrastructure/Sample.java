package com.example.inditex.infrastructure;

import com.example.inditex.infrastructure.adapters.dto.PriceRequest;

public class Sample {

    public static PriceRequest buildPriceRequest(String date) {
        PriceRequest priceRequest = new PriceRequest();
        priceRequest.setApplicationDate(date);
        priceRequest.setProductId("35455");
        priceRequest.setBrandId(1L);
        return priceRequest;
    }
}
