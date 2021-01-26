package entity.user;

import auth.credential.PhoneCredential;
import auth.idtokenreport.IdTokenReport;
import entity.SuperEntity;
import exception.authexception.*;
import job.Job;

public abstract class UserEntity extends SuperEntity implements UserInfo {
    public UserEntity() {
        super();
    }

    public abstract String getEmail();

    public Job<IdTokenReport> getAuthIdToken (boolean forceRefresh) throws AuthInvalidEntityException {
        return null;
    }

    public abstract UserMetadata getMetadata();

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
