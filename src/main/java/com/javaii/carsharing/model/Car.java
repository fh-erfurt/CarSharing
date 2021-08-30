package com.javaii.carsharing.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private long id;

    private String brand;

    private String model;

    private int productionYear;

    private String specification;

    private double basePricePerDay;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @OneToMany(mappedBy = "car")
    private List<Reservation> reservations;


    public List<Reservation> getReservations() {
        return this.reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProductionYear() {
        return this.productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getSpecification() {
        return this.specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public double getBasePricePerDay() {
        return this.basePricePerDay;
    }

    public void setBasePricePerDay(double basePricePerDay) {
        this.basePricePerDay = basePricePerDay;
    }

    public Branch getBranch() {
        return this.branch;
    }

    public void setBranch(Branch location) {
        this.branch = location;
    }

    @Override
    public String toString() {
        return
                "brand='" + this.brand + '\'' +
                        ", model='" + this.model + '\'' +
                        ", productionYear=" + this.productionYear +
                        ", specification='" + this.specification;
    }
}
