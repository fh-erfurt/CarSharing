package archive.service.util.listener.authservicelistener;

import archive.service.authservice.AuthService;

public interface AuthServiceStateListener {
    public abstract void onAuthStateChanged(AuthService authService);
}
