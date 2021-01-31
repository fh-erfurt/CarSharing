package archive.main.map_beta.callback;

import archive.main.map_beta.connection.ConnectionResult;

public interface OnConnectionFailedListener {
    void onConnectionFailed(ConnectionResult connectionResult);
}
