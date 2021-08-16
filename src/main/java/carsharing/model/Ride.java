package carsharing.model;

/*
 * @author Dave Akinyemi
 * @date August 15, 2021.
 * @version 3.0
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rides")
public class Ride {
    @Id
    @Column(name = "rideid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "driverid")
    private int driverId;

    @Column(name = "drivername")
    private String driverName;

    @Column(name = "startlocation")
    private String startLocation;

    @Column(name = "vehicle")
    private String vehicle;

    @Column(name = "regnum")
    private String regNum;

    @Column(name = "numofseats")
    private int numOfSeats;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    public Ride() {

    }

    public Ride(
        int id, 
        String driverName, 
        String startLocation, 
        String vehicle, 
        String regNum, 
        int numOfSeats
        ) {
        super();
        this.id = id;
        this.driverName = driverName;
        this.startLocation = startLocation;
        this.vehicle = vehicle;
        this.regNum = regNum;
        this.numOfSeats = numOfSeats;
    }

    /*
     * date
     */

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    /*
     * time
     */

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    /*
     * ride id
     */

    public int getRideId() {
        return this.id;
    }

    public void setRideId(int id) {
        this.id = id;
    }

    /*
     * driver id
     */

    public int getDriverId() {
        return this.driverId;
    }

    public void setDriverId(int id) {
        this.driverId = id;
    }

    /*
     * driver name
     */

    public String getDriverName() {
        return this.driverName;
    }

    public void setDriverName(String name) {
        this.driverName = name;
    }

    /*
     * ride start location
     */

    public String getStartLocation() {
        return this.startLocation;
    }

    public void setStartLocation(String location) {
        this.startLocation = location;
    }

    /*
     * vehicle
     */

    public String getVehicle() {
        return this.vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    /*
     * registration number
     */

    public String getRegNum() {
        return this.regNum;
    }

    public void setRegnum(String number) {
        this.regNum = number;
    }

    /*
     * number of seats 
     */

    public int getNumOfSeats() {
        return this.numOfSeats;
    }

    public void setNumOfSeats(int number) {
        this.numOfSeats = number;
    }
}
