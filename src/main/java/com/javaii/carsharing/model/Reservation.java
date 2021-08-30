package com.javaii.carsharing.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private LocalDateTime reservationDate;

    private LocalDateTime reservationStart, reservationEnd;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private double cost;

    @OneToOne(mappedBy ="reservation", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "rental_id")
    private Rental rental;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public LocalDateTime getReservationDate() {
        return this.reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public LocalDateTime getReservationStart() {
        return this.reservationStart;
    }

    public void setReservationStart(LocalDateTime reservationStart) {
        this.reservationStart = reservationStart;
    }

    public LocalDateTime getReservationEnd() {
        return this.reservationEnd;
    }

    public void setReservationEnd(LocalDateTime reservationEnd) {
        this.reservationEnd = reservationEnd;
    }

    public Car getCar() {
        return this.car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }


    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + this.id +
                ", reservationDate=" + this.reservationDate +
                ", reservationStart=" + this.reservationStart +
                ", reservationEnd=" + this.reservationEnd +
                ", car=" + this.car +
                ", customer=" + this.customer +
                ", cost=" + this.cost +
                '}';
    }
}
