package data;

import model.location.Location;

import java.util.HashMap;

/**
 * The DriversAvailable class builds a "dummy" database
 * for the users which will be drivers.
 */

public final class DriversAvailable {
    private static final HashMap<String, Location> driverLocations = new HashMap<String, Location>();

    public static void addDriver(String userId, Location location){
        driverLocations.put(userId, location);
    }

    public static void updateDriverLocation(String userId, Location location){
        driverLocations.replace(userId, location);
    }

    public static Location getDriverLocation(String userId){
        return driverLocations.get(userId);
    }

    public static HashMap<String, Location> getDriverLocations(){
        return DriversAvailable.driverLocations;
    }
}
