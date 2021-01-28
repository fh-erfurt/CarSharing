package entity.beta.appentity;

import auth.beta.idtoken.IdTokenResult;
import exception.authexception.AuthInvalidUserException;
import job.Job;

import java.io.Serializable;

public abstract class AppEntity implements AppEntityInfo, Serializable {
    public AppEntity() {

    }

    public Job<IdTokenResult> getIDToken (boolean forceRefresh) throws AuthInvalidUserException {
        return null;
    }






}
