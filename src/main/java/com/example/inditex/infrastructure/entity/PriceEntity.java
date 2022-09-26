package com.example.inditex.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Prices")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long brandId;
    private String startDate;
    private String endDate;
    private Long priceList;
    private String productId;
    private Integer priority;
    private Double price;
    @Column(name = "curr")
    private String currency;
}
