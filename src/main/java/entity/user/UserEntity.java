package entity.user;

import auth.authidtokenresult.EntityAuthIDTokenResult;
import auth.authcredential.PhoneAuthCredential;
import auth.authidtokenresult.VehicleBookedAuthIDTokenResult;
import entity.SuperEntity;
import exception.*;
import job.Job;

public abstract class UserEntity extends SuperEntity implements UserInfo {
    public UserEntity() {
        super();
    }

    public abstract String getEmail();

    public Job<VehicleBookedAuthIDTokenResult> getAuthIDToken (boolean forceRefresh) throws AuthInvalidEntityException {
        return null;
    }

    public Job<EntityAuthIDTokenResult> getVehicleBookedIDToken (boolean forceRefresh) throws AuthInvalidEntityException, BookingTokenExpiredException {
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

    public Job<Void> updatePhoneNumber(PhoneAuthCredential credential) throws AuthEntityCollisionException, AuthInvalidEntityException, AuthRecentLoginRequiredException {
        return null;
    }

    public Job<Void> verifyBeforeUpdateEmail(String newEmail) {
        return null;
    }

}
