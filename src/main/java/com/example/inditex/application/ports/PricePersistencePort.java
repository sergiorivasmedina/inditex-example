package com.example.inditex.application.ports;

import com.example.inditex.domain.Price;

import java.util.List;

public interface PricePersistencePort {
    List<Price> getPricesForProduct(String productId, Long brandId);
}
