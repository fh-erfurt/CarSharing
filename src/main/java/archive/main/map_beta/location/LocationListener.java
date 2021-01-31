package archive.main.map_beta.location;

import model.location.Location;
import archive.main.map_beta.MapClient;

public interface LocationListener {
    // Called when the archive.main.location has changed.
    void onLocationChanged(Location location);
    void onStatusChanged(int status);
    void onEnabled(MapClient client);
    void onDisabled(MapClient client);
}
