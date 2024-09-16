package com.inditex.prueba.tecnica.prices.application.web.model;

import com.inditex.prueba.tecnica.prices.config.EntityMapper;
import com.inditex.prueba.tecnica.prices.domain.model.Price;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface PriceMapper extends EntityMapper<PriceResponse, Price> {

    PriceResponse toDto(Price price);

    Price toEntity(PriceResponse response);
}
