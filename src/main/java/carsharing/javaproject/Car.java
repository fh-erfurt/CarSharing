package carsharing.javaproject;

import java.time.*;

public class Car {

    private String brand, model, rideStart;

    private char type, status;

    private float km;

    private int fuel;

    private Boolean inUse, isReserved;

    private User user;

    private GeoLocation location;

    private LocalDate nextService;

    public Car () {

    }

    void changeStatus (char status) {

    }

    void addKm (float drivenKm) {

    }

    LocalTime timeUntilNextService () {
        return null;
    }

    void startRide () {

    }

    void endRide () {

    }

}
