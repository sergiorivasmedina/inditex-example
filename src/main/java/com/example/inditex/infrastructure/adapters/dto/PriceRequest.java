package com.example.inditex.infrastructure.adapters.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class PriceRequest {
    @NotNull
    private String applicationDate;
    @NotNull
    private String productId;
    @NotNull
    private Long brandId;
}
