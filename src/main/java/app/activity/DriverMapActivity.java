package app.activity;

import map_beta.AppMap;
import map_beta.Bundle;
import map_beta.MapClient;
import map_beta.callback.ConnectionCallbacks;
import map_beta.callback.OnMapReadyCallback;
import map_beta.location.Location;
import map_beta.location.LocationListener;
import map_beta.location.LocationRequest;
import org.jetbrains.annotations.Nullable;

public class DriverMapActivity extends MapActivity implements ConnectionCallbacks, OnMapReadyCallback, LocationListener {

    private AppMap map;
    MapClient client;
    Location lastLocation;
    LocationRequest locationRequest;

    @Override
    public void onMapReady(AppMap map) {

    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(int status) {

    }

    @Override
    public void onEnabled(MapClient client) {

    }

    @Override
    public void onDisabled(MapClient client) {

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        //locationRequest = new LocationRequest()
    }

    @Override
    public void onConnectionSuspended(int i) {

    }
}
