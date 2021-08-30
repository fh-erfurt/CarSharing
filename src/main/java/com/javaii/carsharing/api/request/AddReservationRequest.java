package com.javaii.carsharing.api.request;

import com.javaii.carsharing.model.Car;
import com.javaii.carsharing.model.Customer;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;

public class AddReservationRequest {

    private LocalDateTime reservationDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime reservationStart, reservationEnd;

    private Car car;
    private Customer customer;
    private long branchId;
    private double cost;

    public AddReservationRequest() {
        this.reservationDate = LocalDateTime.now();
    }

    public AddReservationRequest(Car car, Customer customer) {
        this();
        this.car = car;
        this.customer = customer;
    }

    private LocalDateTime parse(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try{
            return (LocalDateTime) formatter.parse(dateString);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
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

    public long getBranchId() {
        return this.branchId;
    }

    public void setBranchId(long branchId) {
        this.branchId = branchId;
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

}
