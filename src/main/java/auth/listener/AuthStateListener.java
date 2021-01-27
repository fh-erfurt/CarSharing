package auth.listener;

import auth.AppEntityAuth;

public interface AuthStateListener {
    void onAuthStateChanged(AppEntityAuth appEntityAuth);
}
