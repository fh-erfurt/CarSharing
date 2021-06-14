package model;

import java.util.*;
/**
 * Route model class
 */

public class Route {
    private final List<Location> locations;
    private String name;

    /**
     * constructor method
     *
     * @param locations - location chain
     * @param name - route name
     */

    public Route(List<Location> locations, String name) {
        this.locations = locations;
        this.name = name;
    }

    /**
     * object comparison method
     *
     * @param o - object to compare
     * @return true or false based on equality
     */

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        Route route = (Route) o;

        return Objects.equals(this.locations, route.locations);
    }

    /**
     * @return object hashcode
     */

    @Override
    public int hashCode() {
        return this.locations != null ? locations.hashCode() : 0;
    }

    /**
     * @return location chain
     */

    public List<Location> getLocations() {
        return this.locations;
    }

    /**
     * @return route name
     */

    public String getName() {
        return this.name;
    }

    /**
     * @param name - route name
     */

    public void setName (String name) {
        this.name = name;
    }

    /**
     * @return route as string value
     */

    @Override
    public String toString() {
        return name;
    }
}
