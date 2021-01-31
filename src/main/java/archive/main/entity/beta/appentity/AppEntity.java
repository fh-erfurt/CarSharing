package archive.main.entity.beta.appentity;

import archive.main.auth.beta.idtoken.IdTokenResult;
import archive.main.exception.authexception.AuthInvalidUserException;
import archive.main.job.Job;

import java.io.Serializable;

public abstract class AppEntity implements AppEntityInfo, Serializable {
    public AppEntity() {

    }

    public Job<IdTokenResult> getIDToken (boolean forceRefresh) throws AuthInvalidUserException {
        return null;
    }






}
