package model;

import util.InvalidDataException;
import util.Verification;

import java.time.LocalDate;

/**
 * Vehicle model class
 */

public class Vehicle {

    private String type,
                   model,
                   plateNumber,
                   color;

    private int year,
                numOfSeats;

    private LocalDate warrantyOfFitnessExpiry,
                      registrationExpiry;

    private double efficiency;

    /**
     * vehicle constructor - initializes a vehicle with the specified data
     *
     * @param type - vehicle type
     * @param model - vehicle model
     * @param plateNumber - vehicle plate number
     * @param year - vehicle release year
     * @param numOfSeats - number of passenger seats in vehicle
     * @throws InvalidDataException on invalid data
     */

    public Vehicle(String type,
                   String model,
                   String plateNumber,
                   int year,
                   int numOfSeats) throws InvalidDataException {

        if (Verification.vehicleBuild(year, numOfSeats)) {
            this.init(type, model, plateNumber, year, numOfSeats);
        } else {
            throw new InvalidDataException();
        }

    }

    /**
     * @return vehicle type
     */

    public String getType () {
        return this.type;
    }

    /**
     * @return vehicle model
     */

    public String getModel () {
        return this.model;
    }

    /**
     * @return vehicle plate number
     */

    public String getPlate () {
        return this.plateNumber;
    }

    /**
     * @return vehicle release year
     */

    public int getYear () {
        return this.year;
    }

    /**
     * @return number of passenger seats in vehicle
     */

    public int getNumOfSeats () {
        return this.numOfSeats;
    }

    /**
     * secondary vehicle initialisation method
     *
     * @param type - vehicle type
     * @param model - vehicle model
     * @param plateNumber - vehicle plate number
     * @param year - vehicle release year
     * @param numOfSeats - number of passenger seats in vehicle
     */

    private void init (String type,
                       String model,
                       String plateNumber,
                       int year,
                       int numOfSeats) {
        this.type = type;
        this.model = model;
        this.plateNumber = plateNumber;
        this.year = year;
        this.numOfSeats = numOfSeats;
    }

    /**
     * comparison method override
     *
     * @param object - comparison object
     * @return true or false on comparison of equality
     */

    @Override
    public boolean equals (Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }

        Vehicle vehicle = (Vehicle) object;

        return this.plateNumber.equals(vehicle.plateNumber);
    }

    /**
     * @return hashcode
     */

    @Override
    public int hashCode () {
        return this.plateNumber.hashCode();
    }

    /**
     * @return vehicle as string value
     */

    @Override
    public String toString () {
        return this.plateNumber + ": " +
                this.year + " " +
                this.color + " " +
                this.model + " type " +
                this.type + " with " +
                this.numOfSeats + " seats.";
    }

    /**
     * set warranty of fitness expiry for vehicle
     *
     * @param expiry - warranty of fitness expiry date
     */

    public void setWarrantyOfFitnessExpiry (LocalDate expiry) {
        this.warrantyOfFitnessExpiry = expiry;
    }

    /**
     * @return warranty of fitness expiry for vehicle
     */

    public LocalDate getWarrantyOfFitnessExpiry () {
        return this.warrantyOfFitnessExpiry;
    }

    /**
     * set expiration date of vehicle registration
     *
     * @param expiry - registration expiry date
     */

    public void setRegistrationExpiry (LocalDate expiry) {
        this.registrationExpiry = expiry;
    }

    /**
     * @return expiration date of vehicle registration
     */

    public LocalDate getRegistrationExpiry () {
        return this.registrationExpiry;
    }

    /**
     * set vehicle efficiency value
     *
     * @param efficiency - vehicle efficiency as double value
     */

    public void setEfficiency (double efficiency) {
        this.efficiency = efficiency;
    }

    /**
     * @return vehicle efficiency
     */

    public double getEfficiency () {
        return this.efficiency;
    }
}
