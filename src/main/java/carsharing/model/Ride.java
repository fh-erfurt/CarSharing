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
    private int rideId;

    @Column(name = "driverid")
    private int driverId;

    @Column(name = "drivername")
    private String driverName;

    @Column(name = "fromlocation")
    private String fromLocation;

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
}
