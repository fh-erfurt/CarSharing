package carsharing.javaproject;

import java.time.*;

public class GeoLocation {

    private LocalDateTime lastSeen;

    private float latitude, longitude;

    public GeoLocation() {
        //By default the last seen time will set to the current timestamp.
        this.lastSeen = LocalDateTime.now();
    }

    //Constructor witch can be called and all needed variables be set.

    public GeoLocation(float _lat, float _long, LocalDateTime _date) {
        this.latitude = _lat;
        this.longitude = _long;

    //last seen Time can be optionally set in parameter. If its not set, the current timestamp will be used!

        if (_date == null) {
            this.lastSeen = LocalDateTime.now();
        }
        else {

            this.lastSeen= _date;
        }
    }

    // Getter / Setter -----------------------------------------------

    public LocalDateTime getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(LocalDateTime _lastSeen) {
        this.lastSeen = _lastSeen;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float _long) {
        this.longitude = _long;
    }

    public void setLatitude (float _lat) {
        this.latitude = _lat;
    }

    public float getLatitude () {

        return this.latitude;
    }



}
