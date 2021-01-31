package auth;

import task.Task;
import exception.InvalidCredentialException;
import exception.InvalidUserException;
import exception.UserCollisionException;
import exception.WeakPasswordException;
import model.user.User;
import outofbandcode.OOBCodeResponse;

public class Auth {

    public void addAuthListener(AuthListener listener) {

    }

    public void removeAuthListener(AuthListener listener) {

    }

    public static Auth getInstance(){
        return null;
    }

    // oob = out of band
    public Task<Void> applyOOBCode(String code) {
        return null;
    }

    public Task<OOBCodeResponse> checkOOBCode(String code) {
        return null;
    }

    public Task<AuthResponse> createUser(String email, String password)
            throws WeakPasswordException, InvalidCredentialException, UserCollisionException {
        return null;
    }
    public Task<AuthResponse> signIn(String email, String password)
            throws InvalidUserException, InvalidCredentialException {
        return null;
    }

    public Task<Void> confirmPasswordReset(String code, String newPassword)
            throws IllegalArgumentException, InvalidUserException, WeakPasswordException {
        return null;
    }

    public User getCurrentUser(){
        return null;
    }

    public Task<Void> sendPasswordResetEmail(String email) {
        return null;
    }

    public Task<Void> updateCurrentUser(User user) {
        return null;
    }

    public Task<String> verifyPasswordResetCode(String code) {
        return null;
    }
}
