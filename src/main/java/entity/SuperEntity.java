package entity;

import auth.credential.Credential;
import auth.AuthReport;
import auth.idtokenreport.IdTokenReport;
import exception.authexception.AuthInvalidCredentialException;
import exception.authexception.AuthInvalidEntityException;
import exception.authexception.AuthRecentLoginRequiredException;
import job.Job;

import java.io.Serializable;

public abstract class SuperEntity implements EntityInfo, Serializable {
    public SuperEntity() {

    }

    public Job<Void> delete() throws AuthInvalidEntityException, AuthRecentLoginRequiredException {
        return null;
    }

    public abstract String getDisplayName();

    public Job<IdTokenReport> getIDToken (boolean forceRefresh) throws AuthInvalidEntityException {
        return null;
    }

    public abstract String getPhotoUrl();

    public abstract String getId();

    public Job<Void> reauthenticate(Credential credential) throws AuthInvalidEntityException, AuthInvalidCredentialException {
        return null;
    }

    public Job<AuthReport> reauthenticateAndRetrieveData(Credential credential) throws AuthInvalidEntityException, AuthInvalidCredentialException {
        return null;
    }

    public Job<Void> reload() throws AuthInvalidEntityException {
        return null;
    }

    public Job<Void> updateProfile(EntityProfileChangeRequest request) throws AuthInvalidEntityException {
        return null;
    }
}
