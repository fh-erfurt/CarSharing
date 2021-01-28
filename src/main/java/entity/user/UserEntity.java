package entity.user;

import auth.AppAuthResult;
import auth.credential.Credential;
import auth.credential.PhoneCredential;
import auth.IdTokenResult;
import exception.authexception.*;
import job.Job;

public abstract class UserEntity implements UserEntityInfo {
    public UserEntity() {

    }

    public abstract String getEmail();

    public abstract String getDisplayName();

    public abstract String getPhotoUrl();

    public abstract String getId();

    public abstract String getPhoneNumber();

    public Job<IdTokenResult> getAuthIdToken (boolean forceRefresh) throws AuthInvalidUserException {
        return null;
    }

    public abstract UserEntityMetadata getMetadata();

    public Job<Void> sendEmailVerification() {
        return null;
    }

    public Job<Void> updateEmail (String email) throws AuthInvalidUserException, AuthInvalidCredentialException, AuthUserCollisionException, AuthRecentLoginRequiredException {
        return null;
    }

    public Job<Void> updatePassword(String password) throws AuthWeakPasswordException, AuthInvalidUserException, AuthRecentLoginRequiredException {
        return null;
    }

    public Job<Void> updatePhoneNumber(PhoneCredential credential) throws AuthUserCollisionException, AuthInvalidUserException, AuthRecentLoginRequiredException {
        return null;
    }

    public Job<Void> verifyBeforeUpdateEmail(String newEmail) {
        return null;
    }

    public Job<Void> delete() throws AuthInvalidUserException, AuthRecentLoginRequiredException {
        return null;
    }

    public Job<Void> reauthenticate(Credential credential) throws AuthInvalidUserException, AuthInvalidCredentialException {
        return null;
    }

    public Job<AppAuthResult> reauthenticateAndRetrieveData(Credential credential) throws AuthInvalidUserException, AuthInvalidCredentialException {
        return null;
    }

    public Job<Void> reload() throws AuthInvalidUserException {
        return null;
    }

    public Job<Void> updateProfile(UserEntityProfileChangeRequest request) throws AuthInvalidUserException {
        return null;
    }

}
