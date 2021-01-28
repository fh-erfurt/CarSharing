package auth;

import auth.authcredential.AuthCredential;
import entity.beta.appentity.AppEntity;

public interface AppAuthResult {
    AuthCredential getCredential();
    // Returns the currently signed-in User,
    // or null if there isn't any (i.e. the user is signed out).
    AppEntity getEntity();
}
