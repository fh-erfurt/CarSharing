package entity.user;

import auth.credential.PhoneCredential;
import auth.idtokenreport.IdTokenResult;
import entity.AppEntity;
import exception.authexception.*;
import job.Job;

public abstract class UserEntity extends AppEntity implements UserEntityInfo {
    public UserEntity() {
        super();
    }

    public abstract String getEmail();

    public Job<IdTokenResult> getAuthIdToken (boolean forceRefresh) throws AuthInvalidEntityException {
        return null;
    }

    public abstract UserEntityMetadata getMetadata();

    public abstract String getPhoneNumber();

    public Job<Void> sendEmailVerification() {
        return null;
    }

    public Job<Void> updateEmail (String email) throws AuthInvalidEntityException, AuthInvalidCredentialException, AuthEntityCollisionException, AuthRecentLoginRequiredException {
        return null;
    }

    public Job<Void> updatePassword(String password) throws AuthWeakPasswordException, AuthInvalidEntityException, AuthRecentLoginRequiredException {
        return null;
    }

    public Job<Void> updatePhoneNumber(PhoneCredential credential) throws AuthEntityCollisionException, AuthInvalidEntityException, AuthRecentLoginRequiredException {
        return null;
    }

    public Job<Void> verifyBeforeUpdateEmail(String newEmail) {
        return null;
    }

}
