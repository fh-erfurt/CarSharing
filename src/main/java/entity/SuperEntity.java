package entity;

import auth.authcredential.AuthCredential;
import auth.AuthReport;
import auth.authidtokenresult.SuperAuthIDTokenResult;
import exception.AuthInvalidCredentialException;
import exception.AuthInvalidEntityException;
import exception.AuthRecentLoginRequiredException;
import job.Job;

import java.io.Serializable;

public abstract class SuperEntity implements EntityInfo, Serializable {
    public SuperEntity() {

    }

    public Job<Void> delete() throws AuthInvalidEntityException, AuthRecentLoginRequiredException {
        return null;
    }

    public abstract String getDisplayName();

    public Job<SuperAuthIDTokenResult> getIDToken (boolean forceRefresh) throws AuthInvalidEntityException {
        return null;
    }

    public abstract String getPhotoUrl();

    public abstract String getId();

    public Job<Void> reauthenticate(AuthCredential credential) throws AuthInvalidEntityException, AuthInvalidCredentialException {
        return null;
    }

    public Job<AuthReport> reauthenticateAndRetrieveData(AuthCredential credential) throws AuthInvalidEntityException, AuthInvalidCredentialException {
        return null;
    }

    public Job<Void> reload() throws AuthInvalidEntityException {
        return null;
    }

    public Job<Void> updateProfile(EntityProfileChangeRequest request) throws AuthInvalidEntityException {
        return null;
    }
}
