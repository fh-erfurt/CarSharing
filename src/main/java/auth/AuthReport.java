package auth;

import auth.authcredential.AuthCredential;
import entity.SuperEntity;

public interface AuthReport {
    AuthCredential getCredential();
    SuperEntity getEntity();
}
