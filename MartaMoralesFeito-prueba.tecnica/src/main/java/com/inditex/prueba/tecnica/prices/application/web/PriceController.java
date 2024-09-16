package com.inditex.prueba.tecnica.prices.application.web;

import com.inditex.prueba.tecnica.prices.application.web.model.PriceResponse;
import com.inditex.prueba.tecnica.prices.domain.service.PriceService;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/price")
@Validated
public class PriceController {

    @Autowired
    PriceService priceService;

    @GetMapping
    ResponseEntity<PriceResponse> findPrice(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                                            LocalDateTime applicationDate,
                                            @RequestParam @Min(value = 1, message = "ProductId must be more than zero") Long productId,
                                            @RequestParam @Min(value = 1, message = "BranId must be more than zero") Long brandId) {
        return ResponseEntity.ok(priceService.findPrice(productId, brandId, applicationDate));
    }
}
