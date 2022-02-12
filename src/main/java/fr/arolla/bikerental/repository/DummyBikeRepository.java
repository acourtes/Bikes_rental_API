package fr.arolla.bikerental.repository;

import fr.arolla.bikerental.domain.Bike;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class DummyBikeRepository implements BikeRepository{
    private static final HashMap<Integer, Bike> BIKE_BY_ID = new HashMap<>(3);
    static {
        BIKE_BY_ID.put(1, new Bike(123, false));
        BIKE_BY_ID.put(2, new Bike(456, false));
        BIKE_BY_ID.put(3, new Bike(789, true));
    }
    @Override
    public Bike getBike(Integer bikeId) {
        return BIKE_BY_ID.getOrDefault(bikeId, new Bike(0, false));
    }
}
