package com.javaii.carsharing.model;

import javax.persistence.*;

@Entity
@Table(name="address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private long id;

    private String postalCode;
    private String street;
    private String city;
    private String streetNumber;

    public String getPostalCode() {
        return this.postalCode;
    }

    public long getId() {
        return this.id;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetNumber() {
        return this.streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
}
