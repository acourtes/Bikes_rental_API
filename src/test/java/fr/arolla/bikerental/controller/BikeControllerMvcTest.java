package fr.arolla.bikerental.controller;

import fr.arolla.bikerental.domain.Bike;
import fr.arolla.bikerental.service.BikeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BikeController.class)
@ExtendWith(SpringExtension.class)
class BikeControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BikeService bikeService;

    @Test
    void should_get_bike_info() throws Exception {
        var bikeId = 1;
        when(bikeService.getBikeInfo(bikeId))
                .thenReturn(new Bike(bikeId, false));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/bikes/{id}", bikeId)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {"serialId":1,"isRent":false}"""));
    }
}