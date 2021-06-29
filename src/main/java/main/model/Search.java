package main.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;

/**
 * Search main.model class
 */

public class Search {

    /**
     * search for location(s)
     *
     * @param searchString - location string value
     * @return list of corresponding location(s)
     */
    
    public static ObservableList<Location> searchForLocation (String searchString) {
        Set<Location> searchResult = new HashSet<>();
        if (searchString.isEmpty()) {
            return Data.locationsList.sorted();
        } else {
            for (Location location : Data.locationsList.sorted()) {
                if (location.toString().toLowerCase().contains(searchString.toLowerCase())) {
                    searchResult.add(location);
                }
            }
            ObservableList<Location> locations = FXCollections.observableArrayList();
            locations.addAll(searchResult);
            return locations.sorted();
        }
    }

    /**
     * filter rides by location
     *
     * @param sharedRides - rides
     * @param location - location
     * @return corresponding rides for location
     */

    public static ObservableList<Ride> ridesForLocation (ObservableList<Ride> sharedRides, Location location) {
        ObservableList<Ride> result = FXCollections.observableArrayList();
        for (Ride ride : sharedRides) {
            if (ride.getTrip().getRoute().getLocations().contains(location)) {
                result.add(ride);
            }
        }
        return result;
    }

    /**
     * filter rides by search parameter
     * @param sharedRides - rides
     * @param filter - filter value
     * @return filtered rides
     */

    public static Collection<Ride> filterRides (ObservableList<Ride> sharedRides, String filter) {
        Collection<Ride> result = new ArrayList<>();
        for (Ride ride : sharedRides) {
            if (ride.getTrip().getDirection().equalsIgnoreCase(filter)) {
                result.add(ride);
            }
        }
        return result;
    }

}
