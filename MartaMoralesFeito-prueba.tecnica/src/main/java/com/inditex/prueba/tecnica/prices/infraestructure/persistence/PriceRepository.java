package com.inditex.prueba.tecnica.prices.infraestructure.persistence;

import com.inditex.prueba.tecnica.prices.domain.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    @Query("SELECT p FROM Price p WHERE p.productId = :productId AND p.brandId = :brandId " +
            "AND :applicationDate BETWEEN p.startDate AND p.endDate ORDER BY p.priority DESC limit 1")
    Optional<Price> findByCriteriaAndMaxPriority(@Param("productId") Long productId,
                                                 @Param("brandId") Long brandId,
                                                 @Param("applicationDate") LocalDateTime applicationDate);
}
