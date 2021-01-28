package auth;

import auth.authcredential.AuthCredential;
import entity.beta.appentity.AppEntity;

public interface AppAuthResult {
    AuthCredential getCredential();
    AppEntity getEntity();
}
