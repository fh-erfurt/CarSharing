package archive.main.auth;

import archive.main.app.App;
import archive.main.auth.beta.actioncode.ActionCodeResult;
import archive.main.auth.beta.idtoken.IdTokenListener;
import archive.main.auth.listener.AuthStateListener;
import archive.main.entity.beta.appentity.AppEntity;
import archive.main.entity.user.UserEntity;
import archive.main.exception.authexception.*;
import archive.main.job.Job;

// Salma und Sarah

public class Auth extends AppAuth{
    @Override
    public void addAuthStateListener(AuthStateListener listener) {

    }

    @Override
    public void removeAuthStateListener(AuthStateListener listener) {

    }

    @Override
    public void addIdTokenListener(IdTokenListener listener) {

    }

    @Override
    public void removeIdTokenListener(IdTokenListener listener) {

    }

    @Override
    public Job<Void> applyAccessCode(String code) {
        return null;
    }

    @Override
    public Job<ActionCodeResult> checkAccessCode(String code) {
        return null;
    }

    @Override
    public Job<Void> confirmPasswordReset(String code, String newPassword) throws IllegalArgumentException, AuthActionCodeException, AuthInvalidUserException, AuthWeakPasswordException {
        return null;
    }

    @Override
    public Job<AppAuthResult> createUserEntity(String email, String password) throws AuthWeakPasswordException, AuthInvalidCredentialException, AuthUserCollisionException {
        return null;
    }

    @Override
    public App getApp() {
        return null;
    }

    @Override
    public UserEntity getCurrentUserEntity() {
        return null;
    }

    @Override
    public Job<Void> sendPasswordResetEmail(String email) {
        return null;
    }

    @Override
    public Job<AppAuthResult> signInWithEmailAndPassword(String email, String password) throws AuthInvalidUserException, AuthInvalidCredentialException {
        return null;
    }

    @Override
    public void signOut() {

    }

    @Override
    public Job<Void> updateCurrentUserEntity(AppEntity entity) {
        return null;
    }

    @Override
    public Job<String> verifyPasswordResetCode(String code) {
        return null;
    }
}
