package com.javaii.carsharing.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private LocalDateTime issueDate;

    @OneToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getIssueDate() {
        return this.issueDate;
    }

    public void setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }

    public Rental getRental() {
        return this.rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }
}
