package map_beta.location;

import map_beta.MapClient;

public interface LocationListener {
    // Called when the location has changed.
    void onLocationChanged(Location location);
    void onStatusChanged(int status);
    void onEnabled(MapClient client);
    void onDisabled(MapClient client);
}
