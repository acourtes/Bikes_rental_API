package fr.arolla.bikerental.repository;

import fr.arolla.bikerental.domain.Rental;

public interface RentalRepository {
    Rental get(Integer rentalId);

    Rental create(Rental rental);

    Rental update(Rental endedRental);
}
