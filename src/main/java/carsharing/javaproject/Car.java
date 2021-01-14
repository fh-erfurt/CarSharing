package carsharing.javaproject;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Car {
    //Enum for car manufacturers
    public enum brands {dummy,audi,bmw,mercedes,ford,suzuki,vw,seat,skoda}
    //Enum for car types, more types can be added easily and this way the type has a standard
    public enum types {dummy,limousine,hatchback,coupe,convertible,van,suv}
    //Enum for available status for cars : green-all good | yellow-something wrong | red-cannot be used | grey-car "offline"
    public enum status {green,yellow,red,grey}


    private int id; //every car gets its own id --> more easy to identify
    private status carStatus; //status of the car --> see enum status
    private brands carBrand; //brand of the car
    private types carType; //type of the car --> see enum types
    private String model; //model of the car / unique for this car
    private float km; //current km
    //fuel will be set in % --> 0-100%
    private int fuel; //current fuel gauge
    private Boolean inUse, isReserved; // flags
    private User user; // if car is in use/reserved --> the user will e stored here
    private GeoLocation location; // current location of the car
    private LocalDate nextService; // next service date of the car
    private LocalDateTime rideStartTime; // time, at which the ride has started
    private LocalDateTime rideEndTime; // time, at which the ride has ended
    private LocalDateTime reservationStartTime; // time, at which the reservation stated


    //default constructor creates a "dummy" car
    public Car () {
        carStatus = status.grey;
        carBrand = brands.dummy;
        carType = types.dummy;
        model = "dummy";
        km = 0;
        fuel = 0;
        inUse = false;
        isReserved = false;
        location = new GeoLocation();

        //Location of FH Erfurt
        location.setLatitude(50.984667f);
        location.setLongitude(11.041153f);

        //set dummy next service date
        nextService.withYear(2200);
        nextService.withDayOfMonth(1);
        nextService.withDayOfMonth(1);
    }

    public Car (brands _brand, String _model, types _type, float _km) {
        carBrand = _brand;
        model = _model;
        carType = _type;
        km = _km;
        carStatus = status.green;
        inUse = false;
        isReserved = false;
        location = null;
        nextService = null;
        user = null;
        fuel = 100;

        location = new GeoLocation();

        id = StartClass.globalCarManager.getNextAvailableId();
    }

    //change status of the car
    public void changeStatus (status _newStatus) {
        carStatus = _newStatus;
    }

    //add km to the car
    public void addKm (float _drivenKm) {
        km += _drivenKm;
    }

    //set fuel %
    public void setFuel(int _newFuel) {
        fuel = _newFuel;
    }

    //decrease fuel by given %
    public void decreaseFuel (int _fuelLoss) {
        //fuelLoss means the amount of fuel to be decreased!
        fuel -= _fuelLoss;
    }

    //gives back a LocalDate object, which shows the time until next service is needed
    public LocalDate timeUntilNextService () {

        //Helper var to store difference between current Date and next service
        Period periodBetweenDates = Period.between(LocalDate.now(),nextService);

        // Store date in LocalDate var for return.
        LocalDate result = LocalDate.of(periodBetweenDates.getYears(),periodBetweenDates.getMonths(), periodBetweenDates.getDays());

        return result;
    }

    //gives back a LocalTime object which represents how much time is left of the current reservation
    public LocalTime timeLeftOfReservation()
    {
        if (isReserved) {
            //Set result variable
            LocalTime result = null;

            //Set current time
            LocalTime currentTime = LocalTime.now();

            //Get duration between reservation start and now
            Duration durationBetweenTimes = Duration.between(currentTime, reservationStartTime);

            //Set result variable
            result.withHour(durationBetweenTimes.toHoursPart());
            result.withMinute(durationBetweenTimes.toMinutesPart());
            result.withSecond(durationBetweenTimes.toSecondsPart());

            return result;
        }else{
            return null;
        }

    }

    //starts a new ride session
    public void startRide () {
        inUse = true;
        rideStartTime = LocalDateTime.now();
        isReserved = false;
        reservationStartTime = null;
    }

    //ends a currents ride session
    public void endRide () {

        //if a care is in use
        if (inUse) {

            //set time of ride end, to calculate the ride duration - and for history
            rideEndTime = LocalDateTime.now();

            //adding fixed km to the km counter of the car - for testing.
            addKm(25.5f);
            //fuel will be decreased by 10% by default after every ride for testing purpose!
            decreaseFuel(10);

            //todo create Invoice with rideStartTime & rideEndTime --> calculate ride duration!
            //todo safe the ride statistics in RideHistory!

            //reset all needed variables and flags
            inUse = false;
            isReserved = false;
            reservationStartTime = null;
            rideStartTime = null;
            rideEndTime = null;

        }
    }

    // Getter / Setter ----------------------------------------

    public status getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(status carStatus) {
        this.carStatus = carStatus;
    }

    public brands getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(brands carBrand) {
        this.carBrand = carBrand;
    }

    public types getCarType() {
        return carType;
    }

    public void setCarType(types carType) {
        this.carType = carType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getKm() {
        return km;
    }

    public void setKm(float km) {
        this.km = km;
    }

    public int getFuel() {
        return fuel;
    }

    public Boolean getInUse() {
        return inUse;
    }

    public void setInUse(Boolean inUse) {
        this.inUse = inUse;
    }

    public Boolean getReserved() {
        return isReserved;
    }

    public void setReserved(Boolean reserved) {
        isReserved = reserved;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public GeoLocation getLocation() {
        return location;
    }

    public void setLocation(GeoLocation location) {
        this.location = location;
    }

    public LocalDate getNextService() {
        return nextService;
    }

    public void setNextService(LocalDate nextService) {
        this.nextService = nextService;
    }

    public LocalDateTime getRideStartTime() {
        return rideStartTime;
    }

    public void setRideStartTime(LocalDateTime rideStartTime) {
        this.rideStartTime = rideStartTime;
    }

    public LocalDateTime getRideEndTime() {
        return rideEndTime;
    }

    public void setRideEndTime(LocalDateTime rideEndTime) {
        this.rideEndTime = rideEndTime;
    }

    public LocalDateTime getReservationStartTime() {
        return reservationStartTime;
    }

    public void setReservationStartTime(LocalDateTime reservationStartTime) {
        this.reservationStartTime = reservationStartTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int _id) {
        id = _id;
    }
}
