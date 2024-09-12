package com.inditex.prueba.tecnica.prices.domain.service.impl;

import com.inditex.prueba.tecnica.prices.config.exception.PriceNotFoundException;
import com.inditex.prueba.tecnica.prices.domain.model.Price;
import com.inditex.prueba.tecnica.prices.domain.service.PriceService;
import com.inditex.prueba.tecnica.prices.infraestructure.persistence.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    PriceRepository priceRepository;

    @Override
    public Price findPrice(Long productId, Long brandId, LocalDateTime applicationDate) {
        List<Price> prices = priceRepository.findByProductIdAndBrandIdAndDate(productId, brandId, applicationDate);
        return prices.stream()
                .max(Comparator.comparingInt(Price::getPriority))
                .orElseThrow(() -> new PriceNotFoundException("No price found for the given criteria"));
    }
}
