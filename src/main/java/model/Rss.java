package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Rss model class (RDF - Resource description Framework - Site Summary)
 */

public class Rss {
    private final List<Driver> drivers;
    private final List<User> users;
    private final List<Location> locations;

    /**
     * constructor
     */

    public Rss () {
        this.locations = Data.locationsList;
        this.drivers = Data.drivers;
        this.users = Data.users;
    }

    /**
     * @return driver data
     */

    public List<Driver> getDrivers () {
        return this.drivers;
    }

    /**
     * @return user data
     */

    public List<User> getUsers () {
        return this.users;
    }

    /**
     * @return locations
     */

    public List<Location> getDestinations () {
        return this.locations;
    }
}
