package main.model;

import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.TravelMode;
import javafx.beans.property.SimpleStringProperty;
import main.util.InvalidDataException;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.Distance;

import java.io.IOException;
import java.time.*;
import java.util.*;

import static java.util.Collections.min;

/**
 * Trip main.model class
 */

public class Trip {
    private static final double FUEL_PRICE = 2.25;

    private final Route route;
    private final String direction;
    private final Boolean recurring;
    private Set<DayOfWeek> daysActive = new HashSet<>();
    private final Vehicle vehicle;
    private final String finalDestination;
    private Map<String, LocalTime> arrivalTimes = new HashMap<>();
    private LocalDate expirationDate;
    private SimpleStringProperty name;
    private boolean shared = false;
    private static final String apiKey = "AIzaSyAAr5-1q2A5eBh_Y8UXxCVHMGXtcoHX0lk";
    private static final GeoApiContext context = new GeoApiContext();

    /**
     * constructor
     *
     * @param route - trip route
     * @param direction - direction of trip
     * @param recurrent - boolean value for recurring trip
     * @param vehicle - vehicle used
     */

    public Trip (Route route, String direction, Boolean recurrent, Vehicle vehicle, String finalDestination) {
        this.route = route;
        this.direction = direction;
        this.recurring = recurrent;
        this.vehicle = vehicle;
        this.finalDestination = finalDestination;
    }

    /**
     * @param daysActive - days when trip is available
     */

    public void setActiveDays (Set<DayOfWeek> daysActive) {
        if (this.recurring) {
            this.daysActive = daysActive;
        }
    }

    /**
     * set estimated time of arrival
     *
     * @param location - place of destination
     * @param time - arrival time
     */

    public void setDestinationArrivalTime (Location location, LocalTime time) {
        this.arrivalTimes.put(location.toString(), time);
    }

    /**
     *
     * @param expirationDate - expiration date of trip
     */

    public void setExpirationDate (LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * check is expiration date is for trip is valid
     * compare date range with current time
     * compare date range with vehicle WOF & driver's license expiry
     *
     * @param expirationDate - trip expiration date
     * @throws InvalidDataException - on invalid expiration date;
     */

    public void validateExpirationDate (LocalDate expirationDate) throws InvalidDataException {
        if (expirationDate != null &&
                expirationDate.isAfter(LocalDate.now()) &&
                expirationDate.isBefore(this.vehicle.getWarrantyOfFitnessExpiry()) &&
                expirationDate.isBefore(this.vehicle.getRegistrationExpiry()) &&
                expirationDate.isBefore(Data.getDriver().getLicense().getExpiryDate())) {
            this.expirationDate = expirationDate;
        } else {
            throw new InvalidDataException();
        }
    }

    /**
     * @return trip route
     */

    public Route getRoute () {
        return this.route;
    }

    /**
     * @return days trip is active
     */

    public Set<DayOfWeek> getDaysActive () {
        return this.daysActive;
    }

    /**
     * @return location arrival times
     */

    public Map<String, LocalTime> getArrivalTimes () {
        return this.arrivalTimes;
    }

    /**
     * @return trip expiration date
     */

    public LocalDate getExpirationDate () {
        return this.expirationDate;
    }

    /**
     * @param arrivalTimes - location arrival times
     */

    public void setArrivalTimes (Map<String, LocalTime> arrivalTimes) {
        this.arrivalTimes = arrivalTimes;
    }

    /**
     * @param name - name of trip
     */

    public void setName (String name) {
        this.name = new SimpleStringProperty(name);
    }

    /**
     * @return name of trip as SimpleStringProperty (javafx)
     */

    public SimpleStringProperty getNameProperty () {
        return this.name;
    }

    /**
     * @return name of trip
     */

    public String getName () {
        return name.get();
    }

    /**
     * @return trip direction
     */

    public String getDirection () {
        return this.direction;
    }

    /**
     * @return boolean value based on recurring trip
     */

    public Boolean getRecurring () {
        return this.recurring;
    }

    /**
     * @return associated vehicle
     */

    public Vehicle getVehicle () {
        return this.vehicle;
    }

    /**
     * @return final destination of trip
     */

    public String getFinalDestination () {
        return this.finalDestination;
    }

    /**
     * @return trip as string value
     */

    @Override
    public String toString () {
        return this.name.getValue();
    }

    /**
     * setup trip as sharable
     *
     * @param numOfSeats - number of passenger seats available for trip
     * @param driver - vehicle driver
     * @param date - date of trip
     * @return boolean value based on setup success
     */

    public boolean share (int numOfSeats, Driver driver, LocalDate date) {
        LocalTime startTime = min(this.arrivalTimes.values());
        int count = 0;
        int dayCount = 0;
        if (this.recurring) {
            for (DayOfWeek day : this.daysActive) {
                date = date.minusWeeks(count);
                date = date.minusDays(dayCount);
                while (date.isBefore(this.expirationDate)) {
                    if (startTime.isBefore(LocalTime.now().plusHours(1)) && date.equals(LocalDate.now())) {
                        date = date.plusWeeks(1);
                        count++;
                    }
                    while (date.getDayOfWeek().getValue() != day.getValue()) {
                        date = date.plusDays(1);
                        dayCount++;
                    }
                    Ride ride = new Ride(this, numOfSeats, date);
                    driver.addRide(ride);
                    this.shared = true;
                    date = date.plusWeeks(1);
                    count++;
                }
            }
        } else {
            if (!startTime.isBefore(LocalTime.now().plusHours(1))) {
                Ride ride = new Ride(this, numOfSeats, date);
                driver.addRide(ride);
                this.shared = true;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * @return if trip is shared
     */

    public boolean isShared() {
        return this.shared;
    }

    /**
     * @return duration of trip
     */

    public Duration getDuration () {
        List<LocalTime> times = new ArrayList<>(this.arrivalTimes.values());
        Collections.sort(times);
        LocalTime earliest = times.get(0);
        LocalTime latest = times.get(times.size() - 1);
        return Duration.between(earliest, latest);
    }

    /**
     * method for equality
     *
     * @param o - object to be compared
     * @return true or false based on evaluation
     */

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return true;

        Trip trip = (Trip) o;

        if (this.shared != trip.isShared()) return false;
        if (!this.route.equals(trip.route)) return false;
        if (!direction.equals(trip.direction)) return false;
        if (!Objects.equals(this.recurring, trip.recurring)) return false;
        if (!Objects.equals(this.daysActive, trip.daysActive)) return false;
        if (!this.vehicle.equals(trip.vehicle)) return false;
        if (!Objects.equals(this.arrivalTimes, trip.arrivalTimes)) return false;
        return Objects.equals(this.expirationDate, trip.expirationDate);
    }

    @Override
    public int hashCode () {
        int result = this.route.hashCode();
        result = 31 * result + this.direction.hashCode();
        result = 31 * result + (this.recurring != null ? this.recurring.hashCode() : 0);
        result = 31 * result + (this.daysActive != null ? this.daysActive.hashCode() : 0);
        result = 31 * result + this.vehicle.hashCode();
        result = 31 * result + (this.arrivalTimes != null ? this.arrivalTimes.hashCode() : 0);
        result = 31 * result + (this.expirationDate != null ? this.expirationDate.hashCode() : 0);
        result = 31 * result + (this.shared ? 1 : 0);
        return result;
    }

    /**
     * @param shared - set shared value for trip
     */

    public void setShared (boolean shared) {
        this.shared = shared;
    }

    /**
     * calculate cost of trip per passenger
     *
     * @return - cost of trip per passenger
     * @throws InterruptedException - on interruption of thread execution
     * @throws ApiException - on API connection/usage error
     * @throws IOException - on IO error
     */

    public double calculateCostPerPassenger () throws InterruptedException, ApiException, IOException {
        double total = 0;
        Trip.context.setApiKey(Trip.apiKey);
        String[] waypoints = new String[this.route.getLocations().size() - 1];

        for (int i = 0; i < this.route.getLocations().size() - 1; i++) {
            waypoints[i] = this.route.getLocations().get(i + 1).getAddress();
        }

        DirectionsApiRequest distanceRequest = DirectionsApi.newRequest(Trip.context);
        DirectionsResult directionsResult = distanceRequest.destination(this.finalDestination)
                .origin(this.route.getLocations().get(0).getAddress())
                .waypoints(waypoints)
                .mode(TravelMode.DRIVING)
                .await();

        for (int i = 0; i < route.getLocations().size(); i++) {
            Distance distance = directionsResult.routes[0].legs[i].distance;
            total += distance.inMeters;
        }

        double efficiencyPerKm = this.vehicle.getEfficiency() / 100;
        return efficiencyPerKm * (total / 1000) * Trip.FUEL_PRICE;
    }
}
