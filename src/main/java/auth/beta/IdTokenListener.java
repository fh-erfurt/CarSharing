package auth.beta;

import auth.AppAuth;

public interface IdTokenListener {
    void onIdTokenChanged(AppAuth appAuth);
}
