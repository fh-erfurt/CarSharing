package com.javaii.carsharing.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rental")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private long id;

    private boolean wasOverdue;
    private double overduePenalty;
    private LocalDateTime returnDate;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "damage_id")
    private Damage damage;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
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

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public Damage getDamage() {
        return this.damage;
    }

    public void setDamage(Damage damage) {
        this.damage = damage;
    }

    public Reservation getReservation() {
        return this.reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + this.id +
                ", wasOverdue=" + this.wasOverdue +
                ", overduePenalty=" + this.overduePenalty +
                ", returnDate=" + this.returnDate +
                ", damage=" + this.damage +
                ", reservation=" + this.reservation +
                '}';
    }
}
