package fr.arolla.bikerental.controller;

import fr.arolla.bikerental.domain.Bike;
import fr.arolla.bikerental.service.BikeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class BikeControllerTest {

    @Test
    void should_get_bike_info() {
        var bikeService = Mockito.mock(BikeService.class);
        var sut = new BikeController(bikeService);
        var bikeId = 1;
        var expectedBike = new Bike(bikeId, false);
        when(bikeService.getBikeInfo(bikeId))
                .thenReturn(expectedBike);

        var result = sut.getBikeInfo(1);

        assertThat(result).isEqualTo(expectedBike);
    }
}