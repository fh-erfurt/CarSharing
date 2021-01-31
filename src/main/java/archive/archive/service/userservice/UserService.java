package archive.service.userservice;

import archive.service.util.exception.*;
import archive.service.util.actionservice.*;

import java.io.Serializable;

public abstract class UserService extends Object implements Serializable, UserServiceInfo {
    public UserService() {

    }

    public abstract String getName();

    public abstract String getEmail();

    public abstract String getPhoneNumber();

    public abstract String getUid();

    public abstract UserServiceMetadata getUserMetadata();

    public ActionService<Void> delete () throws AuthServiceException {
        return null;
    }

    public ActionService<Void> sendEmailVerification () throws ActionServiceException {
        return null;
    }

    public ActionService<Void> updateEmail () throws ActionServiceException {
        return null;
    }

    public ActionService<Void> updatePassword () throws ActionServiceException {
        return null;
    }

    public ActionService<Void> updatePhoneNumber () throws ActionServiceException {
        return null;
    }

    public ActionService<Void> updateProfile () throws ActionServiceException {
        return null;
    }

}
