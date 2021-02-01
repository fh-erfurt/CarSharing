package data;

import model.location.Location;
import model.user.User;

import java.util.HashMap;

/**
 * The Request class will store customer requests,
 * which will be passed trough to the drivers.
 * At the moment it is just used to pass the requests to the driver.
 */

public class Requests {
    private static final HashMap<String, Location> customerLocations = new HashMap<String, Location>();

    public Requests(){
        HashMap<String, Location> customerLocations = new HashMap<String, Location>();
    }



    public static void addStartRideRequest(String userId, Location location){

        Users.getDriver(userId).startRide();

        if (customerLocations.get(userId) == null)
        {
            //a new Locations will be put
            customerLocations.put(userId, location);
        }
        else
        {
            //otherwise the last locations will be rewritten
            customerLocations.replace(userId, location);
        }

    }

    public static void addEndRideRequest(String userId, Location location){

        Users.getDriver(userId).endRide();

        if (customerLocations.get(userId) == null)
        {
            //a new Locations will be put
            customerLocations.put(userId, location);
        }
        else
        {
            //otherwise the last locations will be rewritten
            customerLocations.replace(userId, location);
        }

    }

    public static void updateLocation(String userId, Location location){

        customerLocations.replace(userId, location);
    }

    public static Location getLocation(String userId){

        return customerLocations.get(userId);
    }
}
