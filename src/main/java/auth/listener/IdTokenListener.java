package auth.listener;

import auth.AppAuth;

public interface IdTokenListener {
    void onIdTokenChanged(AppAuth appAuth);
}
