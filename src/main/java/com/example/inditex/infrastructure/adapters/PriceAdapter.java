package com.example.inditex.infrastructure.adapters;

import com.example.inditex.application.ports.PriceServicePort;
import com.example.inditex.domain.exception.BusinessException;
import com.example.inditex.domain.Price;
import com.example.inditex.infrastructure.adapters.dto.PriceRequest;
import com.example.inditex.infrastructure.adapters.dto.PriceResponse;
import com.example.inditex.infrastructure.adapters.mappers.PriceResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/price")
@RequiredArgsConstructor
public class PriceAdapter {

    private final PriceServicePort priceServicePort;

    @PostMapping("validate-final")
    public ResponseEntity<PriceResponse> validateFinalPrice(@Valid @RequestBody PriceRequest priceRequest) throws BusinessException {
        Price price = priceServicePort.getPricesForProduct(priceRequest.getApplicationDate(), priceRequest.getProductId(), priceRequest.getBrandId());
        return ResponseEntity.status(HttpStatus.OK).body(PriceResponseMapper.INSTANCE.mapToPriceResponse(price));
    }
}
