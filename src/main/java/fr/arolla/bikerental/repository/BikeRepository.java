package fr.arolla.bikerental.repository;

import fr.arolla.bikerental.domain.Bike;

public interface BikeRepository {
    Bike getBike(Integer bikeId);
}
