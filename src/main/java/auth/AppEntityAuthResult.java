package auth;

import auth.credential.Credential;
import entity.AppEntity;

public interface AppEntityAuthResult {
    Credential getCredential();
    AppEntity getEntity();
}
