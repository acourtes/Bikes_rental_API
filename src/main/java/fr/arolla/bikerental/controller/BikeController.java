package fr.arolla.bikerental.controller;

import fr.arolla.bikerental.domain.Bike;
import fr.arolla.bikerental.service.BikeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BikeController {

    private final BikeService bikeService;

    public BikeController(BikeService bikeService) {
        this.bikeService = bikeService;
    }

    @GetMapping("/bikes/{id}")
    public Bike getBikeInfo(@PathVariable("id") int bikeId) {
        return bikeService.getBikeInfo(bikeId);
    }
}
