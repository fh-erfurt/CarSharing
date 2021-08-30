package com.javaii.carsharing.service.impl;

import com.javaii.carsharing.api.request.AddRentalRequest;
import com.javaii.carsharing.model.Damage;
import com.javaii.carsharing.model.Rental;
import com.javaii.carsharing.model.Reservation;
import com.javaii.carsharing.repository.DamageRepository;
import com.javaii.carsharing.repository.RentalRepository;
import com.javaii.carsharing.service.RentalService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
public class RentalServiceImpl implements RentalService {
    private RentalRepository rentalRepository;
    private DamageRepository damageRepository;

    public RentalServiceImpl(RentalRepository rentalRepository, DamageRepository damageRepository) {
        this.rentalRepository = rentalRepository;
        this.damageRepository = damageRepository;
    }

    @Override
    public Long addRental(AddRentalRequest request, Reservation reservation) {
        Rental rental = new Rental();
        rental.setOverduePenalty(request.getOverduePenalty());
        rental.setReservation(reservation);
        LocalDateTime returnDate = request.getReturnDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        rental.setReturnDate(returnDate);
        rental.setWasOverdue(request.isWasOverdue());
        Damage damage = new Damage();
        damageRepository.save(damage);
        rental.setDamage(damage);
        rentalRepository.save(rental);
        System.out.println(rental);
        return rental.getId();
    }

    @Override
    public List<Rental> getAllRentals(long customerId) {
        return rentalRepository.findAll();
    }

    @Override
    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    @Override
    public Rental getRental(long rentalId) {
        return rentalRepository.getById(rentalId);
    }
}
