package com.inditex.prueba.tecnica.prices.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inditex.prueba.tecnica.prices.application.web.PriceController;
import com.inditex.prueba.tecnica.prices.application.web.model.PriceResponse;
import com.inditex.prueba.tecnica.prices.domain.service.PriceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PriceController.class)
public class PriceControllerTest {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PriceService priceService;
    @Autowired
    private ObjectMapper objectMapper;

    // Datos de ejemplo para las respuestas esperadas
    private PriceResponse createPriceResponse() {
        PriceResponse priceResponseMock = new PriceResponse();
        priceResponseMock.setProductId(35455L);
        priceResponseMock.setBrandId(1L);
        priceResponseMock.setPriceList(1L);
        priceResponseMock.setStartDate(LocalDateTime.parse("2020-06-14 00:00:00", formatter));
        priceResponseMock.setEndDate(LocalDateTime.parse("2020-12-31 23:59:59", formatter));
        priceResponseMock.setPrice(35.50);
        priceResponseMock.setCurrency("EUR");
        return priceResponseMock;
    }

    // Helper para crear la URL con parámetros
    private String buildUrl(Long productId, Long brandId, LocalDateTime applicationDate) {
        return String.format("/api/price?applicationDate=%s&productId=%d&brandId=%d",
                applicationDate.format(formatter), productId, brandId);
    }

    // Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
    @Test
    public void testFindPriceAt10AMOn14th() throws Exception {
        LocalDateTime dateTime = LocalDateTime.of(2020, 6, 14, 10, 0, 0);
        PriceResponse response = createPriceResponse();

        when(priceService.findPrice(35455L, 1L, dateTime)).thenReturn(response);

        mockMvc.perform(get(buildUrl(35455L, 1L, dateTime))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(response)));
    }

    // Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
    @Test
    public void testFindPriceAt4PMOn14th() throws Exception {
        LocalDateTime dateTime = LocalDateTime.of(2020, 6, 14, 16, 0, 0);
        PriceResponse response = createPriceResponse();

        when(priceService.findPrice(35455L, 1L, dateTime)).thenReturn(response);

        mockMvc.perform(get(buildUrl(35455L, 1L, dateTime))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(response)));
    }

    // Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
    @Test
    public void testFindPriceAt9PMOn14th() throws Exception {
        LocalDateTime dateTime = LocalDateTime.of(2020, 6, 14, 21, 0, 0);
        PriceResponse response = createPriceResponse();

        when(priceService.findPrice(35455L, 1L, dateTime)).thenReturn(response);

        mockMvc.perform(get(buildUrl(35455L, 1L, dateTime))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(response)));
    }

    // Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
    @Test
    public void testFindPriceAt10AMOn15th() throws Exception {
        LocalDateTime dateTime = LocalDateTime.of(2020, 6, 15, 10, 0, 0);
        PriceResponse response = createPriceResponse();

        when(priceService.findPrice(35455L, 1L, dateTime)).thenReturn(response);

        mockMvc.perform(get(buildUrl(35455L, 1L, dateTime))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(response)));
    }

    // Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
    @Test
    public void testFindPriceAt9PMOn16th() throws Exception {
        LocalDateTime dateTime = LocalDateTime.of(2020, 6, 16, 21, 0, 0);
        PriceResponse response = createPriceResponse();

        when(priceService.findPrice(35455L, 1L, dateTime)).thenReturn(response);

        mockMvc.perform(get(buildUrl(35455L, 1L, dateTime))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(response)));
    }
}
