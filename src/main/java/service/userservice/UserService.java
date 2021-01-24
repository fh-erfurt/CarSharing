package service.userservice;

import service.util.exception.*;
import service.actionservice.*;

import java.io.Serializable;

public abstract class UserService extends Object implements Serializable, UserServiceInfo {
    public UserService() {

    }

    public ActionService<Void> delete () throws AuthServiceException {
        return new ActionServiceDeleteUser<Void>();
    }

    public abstract String getName();

    public abstract String getEmail();

    public abstract UserServiceMetadata getUserMetadata();

    public abstract String getPhoneNumber();

    public abstract String getUid();

    public ActionService<Void> sendEmailVerification () throws ActionServiceException {
        return new ActionServiceSendEmail<Void>();
    }

    public ActionService<Void> updateEmail () throws ActionServiceException {
        return new ActionServiceUpdateUserEmail<Void>();
    }

    public ActionService<Void> updatePassword () throws ActionServiceException {
        return new ActionServiceUpdateUserPassword<Void>();
    }

    public ActionService<Void> updatePhoneNumber () throws ActionServiceException {
        return new ActionServiceUpdateUserPhoneNumber<Void>();
    }

    public ActionService<Void> updateProfile () throws ActionServiceException {
        return new ActionServiceUpdateUserProfile<Void>();
    }

}
