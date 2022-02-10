package fr.arolla.bikerental.domain;

import java.util.Objects;

public class Rental {
    private final Integer rentalId;
    private final Integer bikeId;

    public Rental(Integer rentalId, Integer bikeId) {
        this.rentalId = rentalId;
        this.bikeId = bikeId;
    }

    public Integer getRentalId() {
        return rentalId;
    }

    public Integer getBikeId() {
        return bikeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rental rental = (Rental) o;
        return Objects.equals(rentalId, rental.rentalId) && Objects.equals(bikeId, rental.bikeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rentalId, bikeId);
    }
}
