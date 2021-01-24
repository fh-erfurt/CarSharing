package service.authservice;

import service.util.actionservice.ActionService;
import service.util.actionservice.ActionServiceCreateUser;
import service.util.actionservice.ActionServiceUpdateUserPassword;
import service.util.listener.authservicelistener.AuthServiceStateListener;

public abstract class AuthService extends Object {
    public void addAuthServiceStateListener(AuthServiceStateListener listener) {

    }

    public ActionService<Void> confirmPasswordReset(String code, String newPassword) {
        return new ActionServiceUpdateUserPassword<Void>();
    }

    public ActionService<AuthServiceActionResult> createUser(String emailAddress, String password) {
        return new ActionServiceCreateUser<AuthServiceActionResult>();
    }
}
