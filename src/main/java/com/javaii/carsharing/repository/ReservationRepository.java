package com.javaii.carsharing.repository;

import com.javaii.carsharing.model.Customer;
import com.javaii.carsharing.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByCustomerIs(Customer customer);
}
