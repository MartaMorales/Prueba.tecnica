package com.inditex.prueba.tecnica.prices.domain.service;

import com.inditex.prueba.tecnica.prices.domain.model.Price;

import java.time.LocalDateTime;
import java.util.Date;

public interface PriceService {

 Price findPrice(Long productId, Long brandId, LocalDateTime applicationDate);
}
