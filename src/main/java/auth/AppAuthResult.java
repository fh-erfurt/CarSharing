package auth;

import auth.credential.Credential;
import entity.beta.appentity.AppEntity;

public interface AppAuthResult {
    Credential getCredential();
    AppEntity getEntity();
}
