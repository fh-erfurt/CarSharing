package map_beta.callback;

import map_beta.connection.ConnectionResult;

public interface OnConnectionFailedListener {
    void onConnectionFailed(ConnectionResult connectionResult);
}
