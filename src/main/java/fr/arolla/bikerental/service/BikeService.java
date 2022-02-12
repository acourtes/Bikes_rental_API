package fr.arolla.bikerental.service;

import fr.arolla.bikerental.domain.Bike;
import fr.arolla.bikerental.repository.BikeRepository;
import org.springframework.stereotype.Service;

@Service
public class BikeService {
    private final BikeRepository bikeRepository;

    public BikeService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    public Bike getBikeInfo(Integer bikeId) {
        return bikeRepository.getBike(bikeId);
    }
}
