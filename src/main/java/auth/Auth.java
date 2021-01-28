package auth;

import app.App;
import auth.beta.actioncode.ActionCodeResult;
import auth.beta.idtoken.IdTokenListener;
import auth.listener.AuthStateListener;
import entity.beta.appentity.AppEntity;
import entity.user.UserEntity;
import exception.authexception.*;
import job.Job;

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
