package auth.listener;

import auth.Auth;

public interface IdTokenListener {
    void onIdTokenChanged(Auth auth);
}
