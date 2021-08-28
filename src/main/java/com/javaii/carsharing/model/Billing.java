package com.javaii.carsharing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import static javax.persistence.FetchType.LAZY;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Billing {
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "driverId", referencedColumnName = "driverId")
    @ToString.Exclude
    private User user;
}
