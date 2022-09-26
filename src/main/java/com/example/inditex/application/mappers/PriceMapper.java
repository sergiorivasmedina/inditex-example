package com.example.inditex.application.mappers;

import com.example.inditex.domain.Price;
import com.example.inditex.infrastructure.entity.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PriceMapper {
    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

    List<Price> mapToPriceList(List<PriceEntity> priceEntityList);
}
