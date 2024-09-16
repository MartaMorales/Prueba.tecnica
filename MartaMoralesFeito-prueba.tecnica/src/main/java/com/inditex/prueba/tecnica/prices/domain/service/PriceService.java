package com.inditex.prueba.tecnica.prices.domain.service;

import com.inditex.prueba.tecnica.prices.application.web.model.PriceResponse;

import java.time.LocalDateTime;

public interface PriceService {

    PriceResponse findPrice(Long productId, Long brandId, LocalDateTime applicationDate);
}
