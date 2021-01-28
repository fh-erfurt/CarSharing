package auth.listener;

import auth.AppAuth;

public interface AuthStateListener {
    void onAuthStateChanged(AppAuth appAuth);
}
