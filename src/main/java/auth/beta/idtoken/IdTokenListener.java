package auth.beta.idtoken;

import auth.AppAuth;

public interface IdTokenListener {
    void onIdTokenChanged(AppAuth appAuth);
}
