package service.user;

import service.exception.*;
import service.util.*;

import java.io.Serializable;

public abstract class ServiceUser extends Object implements Serializable, IUserInfo {
    public ServiceUser() {

    }

    public ServiceAction<Void> delete () throws ServiceAuthException {
        return new ServiceActionDeleteUser<Void>();
    }

    public abstract String getName();

    public abstract String getEmail();

    public abstract String getPhoneNumber();

    public abstract String getUid();

    public ServiceAction<Void> sendEmailVerification () throws ServiceException {
        return new ServiceActionSendEmail<Void>();
    }

    public ServiceAction<Void> updateEmail () throws ServiceException {
        return new ServiceActionUpdateUserEmail<Void>();
    }

    public ServiceAction<Void> updatePassword () throws ServiceException {
        return new ServiceActionUpdateUserPassword<Void>();
    }

    public ServiceAction<Void> updatePhoneNumber () throws ServiceException {
        return new ServiceActionUpdateUserPhoneNumber<Void>();
    }

    public ServiceAction<Void> updateProfile () throws ServiceException {
        return new ServiceActionUpdateUserProfile<Void>();
    }

}
