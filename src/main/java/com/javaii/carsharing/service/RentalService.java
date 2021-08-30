package com.javaii.carsharing.service;

import com.javaii.carsharing.api.request.AddRentalRequest;
import com.javaii.carsharing.model.Rental;
import com.javaii.carsharing.model.Reservation;

import java.util.List;

public interface RentalService {
    Long addRental(AddRentalRequest request, Reservation reservation);
    List<Rental> getAllRentals(long customerId);
    List<Rental> getAllRentals();
    Rental getRental(long rentalId);
}
