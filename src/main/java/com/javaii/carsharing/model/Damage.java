package com.javaii.carsharing.model;

import javax.persistence.*;

@Entity
public class Damage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String description;
    private double damagePenalty;

    public Damage() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDamagePenalty() {
        return this.damagePenalty;
    }

    public void setDamagePenalty(double damagePenalty) {
        this.damagePenalty = damagePenalty;
    }
}
