package main.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.util.InvalidDataException;

import java.util.ArrayList;
import java.util.Objects;

/**
 * driver main.model class, derived from user
 */

public class Driver extends User {
    private final ObservableList<Vehicle> vehicles = FXCollections.observableArrayList();
    private final ObservableList<Route> routes = FXCollections.observableArrayList();
    private ObservableList<Trip> trips = FXCollections.observableArrayList();
    private final ObservableList<Ride> rides = FXCollections.observableArrayList();
    private String rating;
    private License license;

    /**
     * constructor
     *
     * @param name - name of driver
     */

    public Driver (String name) {
        this.setName(name);
    }

    /**
     * empty constructor method
     */

    public Driver () {

    }

    /**
     * @param vehicle - vehicle to be added to driver
     */

    public void addVehicle (Vehicle vehicle) {
        if (!this.vehicles.contains(vehicle)) {
            this.vehicles.add(vehicle);
        }
    }

    /**
     * @return vehicles
     */

    public ObservableList<Vehicle> getVehicles () {
        return this.vehicles;
    }

    public void createLocation (int number, String address) {
        Location location = new Location(number, address);
        Data.locations.add(location);
    }

    public void createLocation (int number, String address, String region) {
        Location location = new Location(number, address, region);
        Data.locations.add(location);
    }

    public void createRoute (ObservableList<Location> locations, String name) throws InvalidDataException {
        if (!locations.isEmpty()) {
            ArrayList<Location> destinationsAll = new ArrayList<>(locations);
            Route route = new Route(destinationsAll, name);
            if (!this.routes.contains(route)) {
                routes.add(route);
            }
        } else {
            throw new InvalidDataException();
        }
    }

    public ObservableList<Route> getRoutes() {
        return this.routes;
    }

    public ObservableList<Trip> getTrips () {
        return this.trips;
    }

    public void setTrips (ObservableList<Trip> trips) {
        this.trips = trips;
    }

    public void setRating (String rating) {
        this.rating = rating;
    }

    public String getRating () {
        return this.rating;
    }

    public void addTrip (Trip trip) {
        this.trips.add(trip);
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        Driver driver = (Driver) o;

        if (!Objects.equals(this.vehicles, driver.vehicles)) return false;
        if (!Objects.equals(this.routes, driver.routes)) return false;
        if (!Objects.equals(this.rating, driver.rating)) return false;

        return Objects.equals(this.license, driver.license);
    }

    @Override
    public int hashCode () {
        int result = this.vehicles.hashCode();
        result = 31 * result + this.routes.hashCode();
        result = 31 * result + (this.rating != null ? this.rating.hashCode() : 0);
        result = 31 * result + (this.license != null ? this.license.hashCode() : 0);
        return result;
    }

    public void setLicense (License license) {
        this.license = license;
    }

    public License getLicense () {
        return this.license;
    }

    public ObservableList<Ride> getRides () {
        return this.rides;
    }

    public void addRide (Ride ride) {
        this.rides.add(ride);
    }

}
