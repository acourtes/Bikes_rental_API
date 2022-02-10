package fr.arolla.bikerental.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.arolla.bikerental.domain.Rental;
import fr.arolla.bikerental.service.RentalService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RentalController.class)
@ExtendWith(SpringExtension.class)
public class RentalControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RentalService rentalService;

    @Test
    void should_create_a_rental() throws Exception {
        Integer bikeId = 1;
        var rental = new Rental(null, bikeId);
        when(rentalService.createRental(rental))
                .thenReturn(new Rental(2, bikeId));

        mockMvc.perform(post("/api/v1/rentals")
                        .content(asJsonString(rental))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {"rentalId":2,"bikeId":1}"""));
    }

    @Test
    void should_end_a_rental() throws Exception {
        Integer rentalId = 2;
        when(rentalService.endRental(rentalId))
                .thenReturn(new Rental(rentalId, null));

        mockMvc.perform(put("/api/v1/rentals/{rentalId}", rentalId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {"rentalId":2,"bikeId":null}"""));
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
