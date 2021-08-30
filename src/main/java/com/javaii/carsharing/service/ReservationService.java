package com.javaii.carsharing.service;

import com.javaii.carsharing.api.request.AddReservationRequest;
import com.javaii.carsharing.model.Customer;
import com.javaii.carsharing.model.Reservation;

import java.util.List;
import java.util.Set;

public interface ReservationService {
    Long addReservation(AddReservationRequest request);
    Set<Reservation> getAllReservations(long customerId);
    void deleteReservation(long reservationId);
    List<Reservation> findAll();
    Reservation findById(Long id);
    Long addReservation(Reservation reservation);
    List<Reservation> findReservationsByCustomer(Customer customer);
}
