package data;

import model.location.Location;
import model.user.User;

import java.util.HashMap;

/**
 * The Locations class is  a final class for storing Locations of users.
 * For the testing purpose its like the used database
 */

public final class Locations {
    private static final HashMap<String, HashMap<String, Location>> userLocations = new HashMap<String, HashMap<String, Location>>();
    private static final String driverLocationKey = "DRIVER_LOC";
    private static final String customerLocationKey = "CUSTOMER_LOC";

    public Locations(){
        Locations.init();
    }

    //set hashmaps
    public static void init(){
        HashMap<String, Location> driverList = new HashMap<String, Location>();
        HashMap<String, Location> customerList = new HashMap<String, Location>();
        userLocations.put(driverLocationKey, driverList);
        userLocations.put(customerLocationKey, customerList);
    }

    public static void updateDriverLocation(String userId, Location location){

        //if there is not location connected to the user
        if (userLocations.get(driverLocationKey).get(userId) == null)
        {
            //a new Locations will be put
            userLocations.get(driverLocationKey).put(userId, location);
        }
        else
        {
            //otherwise the last locations will be rewritten
            userLocations.get(driverLocationKey).replace(userId, location);
        }

    }
    //same as above
    public static void updateCustomerLocation(String userId, Location location){

        if (userLocations.get(customerLocationKey).get(userId) == null)
        {
            userLocations.get(customerLocationKey).put(userId, location);
        }
        else
        {
            userLocations.get(customerLocationKey).replace(userId, location);
        }

    }
    //returns locations of specified user via userId
    public static Location getDriverLocation(String userId){

        return userLocations.get(driverLocationKey).get(userId);
    }
    public static Location getCustomerLocation(String userId){
        return userLocations.get(customerLocationKey).get(userId);
    }
    public static HashMap<String, Location> getCustomerLocations(){
        return userLocations.get(customerLocationKey);
    }
    public static HashMap<String, Location> getDriverLocations(){
        return userLocations.get(driverLocationKey);
    }
}
