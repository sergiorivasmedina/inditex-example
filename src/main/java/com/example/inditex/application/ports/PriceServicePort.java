package com.example.inditex.application.ports;

import com.example.inditex.domain.exception.BusinessException;
import com.example.inditex.domain.Price;

public interface PriceServicePort {
    Price getPricesForProduct(String date, String productId, Long brandId) throws BusinessException;
}
