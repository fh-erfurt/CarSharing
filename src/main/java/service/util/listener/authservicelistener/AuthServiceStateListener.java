package service.util.listener.authservicelistener;

import service.authservice.AuthService;

public interface AuthServiceStateListener {
    public abstract void onAuthStateChanged(AuthService authService);
}
