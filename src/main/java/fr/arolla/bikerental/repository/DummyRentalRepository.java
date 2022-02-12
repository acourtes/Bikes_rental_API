package fr.arolla.bikerental.repository;

import fr.arolla.bikerental.domain.Rental;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class DummyRentalRepository implements RentalRepository{
    private final HashMap<Integer, Rental> rentalById = new HashMap<>();
    private int index = 1;

    @Override
    public Rental get(Integer rentalId) {
        return rentalById.get(rentalId);
    }

    @Override
    public Rental create(Rental rental) {
        return rentalById.put(index++, rental);
    }

    @Override
    public Rental update(Rental endedRental) {
        return rentalById.put(endedRental.rentalId(), endedRental);
    }
}
