package archive.service.authservice;

import archive.service.userservice.UserService;
import archive.service.util.actionservice.*;
import archive.service.util.listener.authservicelistener.AuthServiceStateListener;

public abstract class AuthService extends Object {
    public void addAuthServiceStateListener(AuthServiceStateListener listener) {

    }

    public ActionService<Void> confirmPasswordReset(String code, String newPassword) {
        return null;
    }

    public ActionService<AuthServiceActionResult> createUser(String emailAddress, String password) {
        return null;
    }

    public UserService getCurrentUser() {
        return null;
    }

    public void removeAuthServiceStateListener(AuthServiceStateListener listener) {

    }

    public ActionService<Void> sendPasswordResetEmail(String emailAddress) {
        return null;
    }

    public ActionService<AuthServiceActionResult> signIn(String emailAddress, String password){
        return null;
    }

    public void signOut() {

    }

    public ActionService<Void> updateCurrentUser(UserService user) {
        return null;
    }

    public ActionService<String> verifyPasswordResetCode(String code){
        return null;
    }
}
