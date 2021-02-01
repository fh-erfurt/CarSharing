package model.location;

/**
 * The HelloWorld program implements an application that
 * simply displays "Hello World!" to the standard output.
 *
 * @author  Zara Ali
 * @version 1.0
 * @since   2014-03-31
 */

public class Location {
    private final String userId;
    private final double longitude;
    private final double latitude;

    // create and initialize a point with given name and
    // (latitude, longitude) specified in degrees
    public Location(String userId, double latitude, double longitude) {
        this.userId = userId;
        this.latitude  = latitude;
        this.longitude = longitude;
    }

    // return distance between this archive.main.location and that archive.main.location
    // measured in statute miles
    public double distanceTo(Location location) {
        double STATUTE_MILES_PER_NAUTICAL_MILE = 1.15077945;
        double lat1 = Math.toRadians(this.latitude);
        double lon1 = Math.toRadians(this.longitude);
        double lat2 = Math.toRadians(location.latitude);
        double lon2 = Math.toRadians(location.longitude);

        // great circle distance in radians, using law of cosines formula
        double angle = Math.acos(Math.sin(lat1) * Math.sin(lat2)
                + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));

        // each degree on a great circle of Earth is 60 nautical miles
        double nauticalMiles = 60 * Math.toDegrees(angle);
        return STATUTE_MILES_PER_NAUTICAL_MILE * nauticalMiles;
    }

    public double getLongitude(){
        return this.longitude;
    }

    public double getLatitude(){
        return this.latitude;
    }

    // return string representation of this point
    public String toString() {
        return userId + " (" + latitude + ", " + longitude + ")";
    }

}
