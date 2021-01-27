package entity;

import auth.credential.Credential;
import auth.AppEntityAuthResult;
import auth.idtokenreport.IdTokenResult;
import exception.authexception.AuthInvalidCredentialException;
import exception.authexception.AuthInvalidEntityException;
import exception.authexception.AuthRecentLoginRequiredException;
import job.Job;

import java.io.Serializable;

public abstract class AppEntity implements AppEntityInfo, Serializable {
    public AppEntity() {

    }

    public Job<Void> delete() throws AuthInvalidEntityException, AuthRecentLoginRequiredException {
        return null;
    }

    public abstract String getDisplayName();

    public Job<IdTokenResult> getIDToken (boolean forceRefresh) throws AuthInvalidEntityException {
        return null;
    }

    public abstract String getPhotoUrl();

    public abstract String getId();

    public Job<Void> reauthenticate(Credential credential) throws AuthInvalidEntityException, AuthInvalidCredentialException {
        return null;
    }

    public Job<AppEntityAuthResult> reauthenticateAndRetrieveData(Credential credential) throws AuthInvalidEntityException, AuthInvalidCredentialException {
        return null;
    }

    public Job<Void> reload() throws AuthInvalidEntityException {
        return null;
    }

    public Job<Void> updateProfile(AppEntityProfileChangeRequest request) throws AuthInvalidEntityException {
        return null;
    }
}
