package archive.main.auth.beta.idtoken;

import archive.main.auth.AppAuth;

public interface IdTokenListener {
    void onIdTokenChanged(AppAuth appAuth);
}
