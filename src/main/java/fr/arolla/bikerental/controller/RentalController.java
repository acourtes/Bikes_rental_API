package fr.arolla.bikerental.controller;

import fr.arolla.bikerental.domain.Rental;
import fr.arolla.bikerental.service.RentalService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/rentals")
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping
    public Rental createRental(@RequestBody Rental rental) {
        return rentalService.createRental(rental);
    }

    @PutMapping("/{rentalId}")
    public Rental endRental(@PathVariable Integer rentalId) {
        return rentalService.endRental(rentalId);
    }
}
