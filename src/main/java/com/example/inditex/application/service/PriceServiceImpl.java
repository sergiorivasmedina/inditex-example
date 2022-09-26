package com.example.inditex.application.service;

import com.example.inditex.application.ports.PricePersistencePort;
import com.example.inditex.application.ports.PriceServicePort;
import com.example.inditex.domain.exception.BusinessException;
import com.example.inditex.domain.Price;
import com.example.inditex.domain.exception.PriceNotFoundException;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class PriceServiceImpl implements PriceServicePort {

    private final PricePersistencePort pricePersistencePort;

    @Override
    public Price getPricesForProduct(String date, String productId, Long brandId) throws BusinessException {
        return pricePersistencePort.getPricesForProduct(productId, brandId).stream()
                .filter(filterDates(convertStringToLocalDateTime(date)))
                .sorted(Collections.reverseOrder(Comparator.comparing(Price::getPriority)))
                .collect(Collectors.toList())
                .stream().filter(Objects::nonNull).findFirst().orElseThrow(PriceNotFoundException::new);
    }

    private Predicate<Price> filterDates(LocalDateTime date) {
        return price -> convertStringToLocalDateTime(price.getStartDate()).isBefore(date)
                && convertStringToLocalDateTime(price.getEndDate()).isAfter(date);
    }

    private LocalDateTime convertStringToLocalDateTime(String date) { //'2020-06-14-15.00.00'
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        return LocalDateTime.parse(date, formatter);
    }
}
