package fr.arolla.bikerental.service;

import fr.arolla.bikerental.domain.Rental;
import fr.arolla.bikerental.repository.RentalRepository;
import org.springframework.stereotype.Service;

@Service
public class RentalService {

    private final RentalRepository rentalRepository;

    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    public Rental createRental(Rental rental) {
        return rentalRepository.create(rental);
    }

    public Rental endRental(Integer rentalId) {
        Rental rental = rentalRepository.get(rentalId);
        var endedRental = new Rental(rentalId, null);
        return rentalRepository.update(endedRental);
    }
}
