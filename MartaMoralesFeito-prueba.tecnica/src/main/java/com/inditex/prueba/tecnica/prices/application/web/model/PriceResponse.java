package com.inditex.prueba.tecnica.prices.application.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PriceResponse {

    @JsonProperty("productId")
    private Long productId;
    @JsonProperty("brandId")
    private Long brandId;
    @JsonProperty("priceList")
    private Long priceList;
    @JsonProperty("startDate")
    private LocalDateTime startDate;
    @JsonProperty("endDate")
    private LocalDateTime endDate;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("currency")
    private String currency;

}