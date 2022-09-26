package com.example.inditex.config;

import com.example.inditex.application.ports.PricePersistencePort;
import com.example.inditex.application.ports.PriceServicePort;
import com.example.inditex.application.service.PriceServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PriceConfig {
    @Bean
    public PriceServicePort priceService(PricePersistencePort pricePersistencePort) {
        return new PriceServiceImpl(pricePersistencePort);
    }
}
