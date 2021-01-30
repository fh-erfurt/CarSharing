package map_beta.callback;

import map_beta.Bundle;
import org.jetbrains.annotations.Nullable;

public interface ConnectionCallbacks {
    void onConnected(@Nullable Bundle bundle);
    void onConnectionSuspended(int i);
}
