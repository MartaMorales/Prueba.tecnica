package com.inditex.prueba.tecnica.prices.domain;

import com.inditex.prueba.tecnica.prices.application.web.model.PriceResponse;
import com.inditex.prueba.tecnica.prices.domain.service.PriceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PriceServiceTest {

    @Autowired
    private PriceService priceService;

    @Test
    public void testFindPriceAt10AMOn14th() {
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 10, 0, 0);
        PriceResponse price = priceService.findPrice(35455L, 1L, date);
        assertEquals(35.50, price.getPrice());
    }

    @Test
    public void testFindPriceAt16PMOn14th() {
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 16, 0, 0);
        PriceResponse price = priceService.findPrice(35455L, 1L, date);
        assertEquals(25.45, price.getPrice());
    }

    @Test
    public void testFindPriceAt21PMOn14th() {
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 21, 0, 0);
        PriceResponse price = priceService.findPrice(35455L, 1L, date);
        assertEquals(35.50, price.getPrice());
    }

    @Test
    public void testFindPriceAt10AMOn15th() {
        LocalDateTime date = LocalDateTime.of(2020, 6, 15, 10, 0, 0);
        PriceResponse price = priceService.findPrice(35455L, 1L, date);
        assertEquals(30.50, price.getPrice());
    }

    @Test
    public void testFindPriceAt21PMOn16th() {
        LocalDateTime date = LocalDateTime.of(2020, 6, 16, 21, 0, 0);
        PriceResponse price = priceService.findPrice(35455L, 1L, date);
        assertEquals(38.95, price.getPrice());
    }


}
