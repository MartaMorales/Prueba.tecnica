package com.inditex.prueba.tecnica.prices.application.web;

import com.inditex.prueba.tecnica.prices.domain.model.Price;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PriceResponse {
    private Long productId;
    private Long brandId;
    private Long priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double price;
    private String currency;

    public PriceResponse(Price price) {
        this.productId = price.getProductId();
        this.brandId = price.getBrandId();
        this.priceList = price.getPriceList();
        this.startDate = price.getStartDate();
        this.endDate = price.getEndDate();
        this.price = price.getPrice();
        this.currency = price.getCurrency();
    }
}