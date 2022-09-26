package com.example.inditex.application.service;

import com.example.inditex.application.mappers.PriceMapper;
import com.example.inditex.application.ports.PricePersistencePort;
import com.example.inditex.domain.Price;
import com.example.inditex.infrastructure.entity.PriceEntity;
import com.example.inditex.infrastructure.repository.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PricePersistenceServiceImpl implements PricePersistencePort {

    private final PriceRepository priceRepository;

    @Override
    public List<Price> getPricesForProduct(String productId, Long brandId) {
        List<PriceEntity> priceEntityList = priceRepository.findByProductIdAndBrandId(productId, brandId);
        return PriceMapper.INSTANCE.mapToPriceList(priceEntityList);
    }
}
