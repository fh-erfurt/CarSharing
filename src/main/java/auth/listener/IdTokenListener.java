package auth.listener;

import auth.AppEntityAuth;

public interface IdTokenListener {
    void onIdTokenChanged(AppEntityAuth appEntityAuth);
}
