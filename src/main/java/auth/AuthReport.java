package auth;

import auth.credential.Credential;
import entity.SuperEntity;

public interface AuthReport {
    Credential getCredential();
    SuperEntity getEntity();
}
