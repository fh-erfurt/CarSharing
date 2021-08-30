package com.javaii.carsharing.service.impl;

import com.javaii.carsharing.api.request.AddReservationRequest;
import com.javaii.carsharing.model.Customer;
import com.javaii.carsharing.model.Reservation;
import com.javaii.carsharing.repository.ReservationRepository;
import com.javaii.carsharing.service.ReservationService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ReservationServiceImpl implements ReservationService {
    private ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Long addReservation(AddReservationRequest request) {
        Reservation newReservation = new Reservation();
        newReservation.setCar(request.getCar());
        newReservation.setCost(request.getCost());
        newReservation.setCustomer(request.getCustomer());
        newReservation.setReservationDate(request.getReservationDate());
        newReservation.setReservationEnd(request.getReservationEnd());
        newReservation.setReservationStart(request.getReservationStart());
        return reservationRepository.save(newReservation).getId();
    }

    @Override
    public Set<Reservation> getAllReservations(long customerId) {
        return new HashSet<>(reservationRepository.findAll());
    }

    @Override
    public void deleteReservation(long reservationId) {
        reservationRepository.deleteById(reservationId);
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation findById(Long id) {
        return reservationRepository.getById(id);
    }

    @Override
    public Long addReservation(Reservation reservation) {
        return reservationRepository.save(reservation).getId();
    }

    @Override
    public List<Reservation> findReservationsByCustomer(Customer customer) {
        return reservationRepository.findAllByCustomerIs(customer);
    }
}
