package fr.arolla.bikerental.controller;

import fr.arolla.bikerental.domain.Rental;
import fr.arolla.bikerental.service.RentalService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RentalControllerTest {

    @Test
    void should_start_a_rental() {
        RentalService rentalService = mock(RentalService.class);
        int bikeId = 1;
        int rentalId = 2;
        var expectedRental = new Rental(rentalId, bikeId);
        when(rentalService.createRental(new Rental(null, bikeId))).thenReturn(expectedRental);
        var sut = new RentalController(rentalService);

        Rental result = sut.createRental(new Rental(null, bikeId));

        assertThat(result).isEqualTo(expectedRental);
    }

    @Test
    void should_end_a_rental() {
        RentalService rentalService = mock(RentalService.class);
        int rentalId = 2;
        var expectedRental = new Rental(rentalId, null);
        when(rentalService.endRental(rentalId)).thenReturn(expectedRental);
        var sut = new RentalController(rentalService);

        Rental result = sut.endRental(rentalId);

        assertThat(result).isEqualTo(expectedRental);
    }
}
