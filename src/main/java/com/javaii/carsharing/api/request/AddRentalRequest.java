package com.javaii.carsharing.api.request;

import com.javaii.carsharing.model.Reservation;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class AddRentalRequest {
    private boolean wasOverdue;
    private double overduePenalty;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date returnDate;

    private Reservation reservation;

    public Reservation getReservation() {
        return this.reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public boolean isWasOverdue() {
        return this.wasOverdue;
    }

    public void setWasOverdue(boolean wasOverdue) {
        this.wasOverdue = wasOverdue;
    }

    public double getOverduePenalty() {
        return this.overduePenalty;
    }

    public void setOverduePenalty(double overduePenalty) {
        this.overduePenalty = overduePenalty;
    }

    public Date getReturnDate() {
        return this.returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
