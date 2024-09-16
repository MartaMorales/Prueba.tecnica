package com.inditex.prueba.tecnica.prices.config;

public interface EntityMapper<D, E> {
    E toEntity(D dto);

    D toDto(E entity);
}