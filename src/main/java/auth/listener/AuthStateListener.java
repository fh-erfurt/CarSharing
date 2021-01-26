package auth.listener;

import auth.Auth;

public interface AuthStateListener {
    void onAuthStateChanged(Auth auth);
}
