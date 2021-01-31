package archive.main.app.activity.beta;

import archive.main.auth.AppAuth;
import archive.main.map_beta.AppMap;
import archive.main.map_beta.Bundle;
import archive.main.map_beta.MapClient;
import archive.main.map_beta.callback.ConnectionCallbacks;
import archive.main.map_beta.callback.OnMapReadyCallback;
import model.location.Location;
import archive.main.map_beta.location.LocationListener;
import archive.main.map_beta.location.LocationRequest;

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
        this.lastLocation = location;

        // move map camera to archive.main.location's lat & lng
        // animate camera

        assert AppAuth.getInstance() != null;
        String userId = AppAuth.getInstance().getCurrentUserEntity().getUserId();
        X.setLocation(userId, location.getLongitude(), location.getLatitude());
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
    public void onConnected(Bundle bundle) {
        //locationRequest = new LocationRequest()
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    protected void onStop(){
        x.removeLocation(userId);
    }
}
