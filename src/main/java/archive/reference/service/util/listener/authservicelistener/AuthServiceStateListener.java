package archive.reference.service.util.listener.authservicelistener;

import archive.reference.service.authservice.AuthService;

public interface AuthServiceStateListener {
    public abstract void onAuthStateChanged(AuthService authService);
}
