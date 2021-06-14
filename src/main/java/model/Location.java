package model;

import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;

import java.util.Objects;

public class Location {
    private int number;
    private String region,
                   street,
                   name;
    private transient Marker marker;
    private transient MarkerOptions markerOptions;

    public Location(int number, String street) {
        this.number = number;
        this.street = street;
    }

    public Location(int number, String street, String region) {
        this.number = number;
        this.street = street;
    }

    public Location(String name) {
        this.name = name;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (this.number != location.number) return false;
        if (!Objects.equals(this.region, location.region)) return false;
        return Objects.equals(this.street, location.street);
    }

    @Override
    public int hashCode () {
        int result = this.number;
        result = 31 * result + (this.region != null ? this.region.hashCode() : 0);
        result = 31 * result + (this.street != null ? this.street.hashCode() : 0);
        return result;
    }

    @Override
    public String toString () {
        String str = this.number + " " + this.street + "\n";
        if (!(this.region == null)) {
            str += " " + this.region;
        }
        return str;
    }

    public String getAddress () {
        return this.name != null ? this.name : this.number + " " + this.street;
    }

    public void hideMarker (GoogleMap map) {
        if (this.marker != null) {
            map.removeMarker(this.marker);
            this.marker = null;
        }
    }

    public void storeMarker (Marker marker, MarkerOptions markerOptions) {
        this.marker = marker;
        this.markerOptions = markerOptions;
    }

    public Marker restoreMarker () {
        this.marker = new Marker(this.markerOptions);
        return marker;
    }
}
