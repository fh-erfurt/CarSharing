package model;

import com.google.maps.errors.ApiException;
import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Ride implements Comparable<Ride> {

    public enum RideStatus {
        Done, Cancelled, Running, Full
    }

    private final Trip trip;
    private int availableSeats;
    private final Set<User> users = new HashSet<>();
    private final LocalDate date;
    private LocalTime time;
    private final HashMap<String, String> userCancellationReasons = new HashMap<>();
    private String cancellationReason;
    private final Set<User> cancellationsWithoutNotice = new HashSet<>();
    private final Set<User> newCancellations;

    private final SimpleStringProperty name;
    private final SimpleStringProperty startDate;
    private final SimpleStringProperty startTime;
    private SimpleStringProperty rideState;

    public Ride (Trip trip, int availableSeats, LocalDate date) {
        this.trip = trip;
        this.availableSeats = Math.min(availableSeats, trip.getVehicle().getNumOfSeats());
        this.date = date;
        this.newCancellations = new HashSet<>();

        this.changeRideStatus(RideStatus.Running);
        this.name = trip.getNameProperty();
        this.startDate = new SimpleStringProperty(date.toString());
        if (!trip.getArrivalTimes().isEmpty()) {
            List<LocalTime> times = new ArrayList<>(trip.getArrivalTimes().values());
            Collections.sort(times);
            this.time = times.get(0);
            String earliest = times.get(0).toString();
            this.startTime = new SimpleStringProperty(earliest);
        } else {
            this.startTime = new SimpleStringProperty("unknown");
        }
    }

    public int getAvailableSeats () {
        return this.availableSeats;
    }

    public Trip getTrip () {
        return this.trip;
    }

    public String toString () {
        return this.trip.getName();
    }

    public boolean bookRide (User user) {
        if (this.availableSeats > 0) {
            if (this.users.add(user)) {
                this.availableSeats--;
            }
        }

        if (this.availableSeats == 0) {
            this.changeRideStatus(RideStatus.Full);
            return false;
        }

        return true;
    }

    public Set<User> getUsers () {
        return users;
    }

    public String getDetails () throws InterruptedException, ApiException, IOException {
        return "\nVehicle: " + this.trip.getVehicle().toString() + "\nDirection: " + this.trip.getDirection() +
                "\nNumber of Stops: " + this.trip.getArrivalTimes().size() + "\nAvailable Seats: " + this.availableSeats +
                "\nCost: $" + String.format("%.2f", this.trip.calculateCostPerPassenger());
    }

    public int compareTo(Ride o) {
        int compare = this.date.compareTo(o.getDate());
        if (compare == 0) {
            compare = this.time.compareTo(o.time);
        }
        return compare;
    }

    public LocalDate getDate () {
        return this.date;
    }

    public String getName () {
        return this.name.get();
    }

    public String getStartDate () {
        return this.startDate.get();
    }

    public String getStartTime () {
        return this.startTime.get();
    }

    public LocalTime getTime () {
        return this.time;
    }

    public String getRideStatus () {
        if (Data.user != null && this.userCancellationReasons.containsKey(Data.user.getDetails().get("email"))) {
            return "Booking Cancelled";
        }
        return this.rideState.get();
    }

    private void changeRideStatus (RideStatus status) {
        this.rideState = new SimpleStringProperty(status.name());
    }

    public void cancelRide (String reason) {
        this.rideState = new SimpleStringProperty(RideStatus.Cancelled.name());
        this.cancellationReason = reason;
        this.cancellationsWithoutNotice.addAll(this.users);
    }

    public String getCancellationReason () {
        return this.cancellationReason;
    }

    public Set<User> getCanceledWithoutNotice () {
        return this.cancellationsWithoutNotice;
    }

    public void notified (User user) {
        this.cancellationsWithoutNotice.remove(user);
    }

    public void cancel (User user, String reason) {
        this.users.remove(user);
        this.availableSeats += 1;
        this.changeRideStatus(RideStatus.Running);
        this.newCancellations.add(user);
        this.userCancellationReasons.put(user.getDetails().get("email"), reason);
    }

    public HashMap<User, String> notifyDriver () {
        if (!this.newCancellations.isEmpty()) {
            HashMap<User, String> cancelled = new HashMap<>();
            for (User user : this.newCancellations) {
                cancelled.put(user, this.userCancellationReasons.get(user.getDetails().get("email")));
            }
            this.newCancellations.clear();
            return cancelled;
        }
        return new HashMap<>();
    }

    public HashMap<String, String> getUserCancellationReasons () {
        return this.userCancellationReasons;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return true;

        Ride ride = (Ride) o;

        if (this.availableSeats != ride.availableSeats) return false;
        if (!this.trip.equals(ride.trip)) return false;
        if (!Objects.equals(this.users, ride.users)) return false;
        if (!this.date.equals(ride.date)) return false;
        if (!this.time.equals(ride.time)) return false;
        if (this.startDate != null ? !this.startDate.getValue().equals(ride.startDate.getValue()) : ride.startDate != null) return false;
        return startTime != null ? this.startTime.getValue().equals(ride.startTime.getValue()) : ride.startTime == null;
    }

    @Override
    public int hashCode () {
        int result = trip.hashCode();
        result = 31 * result + this.availableSeats;
        result = 31 * result + this.users.hashCode();
        result = 31 * result + this.date.hashCode();
        result = 31 * result + this.time.hashCode();
        result = 31 * result + (this.startDate != null ? this.startDate.hashCode() : 0);
        result = 31 * result + (this.startTime != null ? this.startTime.hashCode() : 0);
        return result;
    }
}
