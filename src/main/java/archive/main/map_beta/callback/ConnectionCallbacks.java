package archive.main.map_beta.callback;

import archive.main.map_beta.Bundle;
import org.jetbrains.annotations.Nullable;

public interface ConnectionCallbacks {
    void onConnected(@Nullable Bundle bundle);
    void onConnectionSuspended(int i);
}
