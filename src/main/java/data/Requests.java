package data;

import model.location.Location;

import java.util.HashMap;

public class Requests {
    private static final HashMap<String, Location> customerLocations = new HashMap<String, Location>();

    public Requests(){
    }

    public static void addRequest(String userId, Location location){
        customerLocations.put(userId, location);
    }

    public static void updateLocation(String userId, Location location){
        customerLocations.replace(userId, location);
    }

    public static Location getLocation(String userId){
        return customerLocations.get(userId);
    }
}
