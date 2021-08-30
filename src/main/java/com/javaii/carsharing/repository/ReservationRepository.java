package com.javaii.carsharing.repository;

import com.javaii.carsharing.model.Customer;
import com.javaii.carsharing.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByCustomerIs(Customer customer);
}
