package com.inditex.prueba.tecnica.prices.domain.service.impl;

import com.inditex.prueba.tecnica.prices.application.web.model.PriceMapper;
import com.inditex.prueba.tecnica.prices.application.web.model.PriceResponse;
import com.inditex.prueba.tecnica.prices.config.exception.PriceNotFoundException;
import com.inditex.prueba.tecnica.prices.domain.model.Price;
import com.inditex.prueba.tecnica.prices.domain.service.PriceService;
import com.inditex.prueba.tecnica.prices.infraestructure.persistence.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    PriceRepository priceRepository;

    @Autowired
    PriceMapper priceMapper;

    @Override
    public PriceResponse findPrice(Long productId, Long brandId, LocalDateTime applicationDate) {
        Optional<Price> opPrice = priceRepository.findByCriteriaAndMaxPriority(productId, brandId, applicationDate);
        if (opPrice.isEmpty())
            throw new PriceNotFoundException("No price found for the given criteria");
        return priceMapper.toDto(opPrice.get());
    }
}
