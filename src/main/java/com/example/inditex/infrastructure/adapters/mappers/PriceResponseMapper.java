package com.example.inditex.infrastructure.adapters.mappers;

import com.example.inditex.domain.Price;
import com.example.inditex.infrastructure.adapters.dto.PriceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PriceResponseMapper {
    PriceResponseMapper INSTANCE = Mappers.getMapper(PriceResponseMapper.class);

    PriceResponse mapToPriceResponse(Price price);
}
