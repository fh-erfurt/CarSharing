package entity.user;

import auth.AppAuthResult;
import auth.authcredential.AuthCredential;
import auth.authcredential.PhoneAuthCredential;
import exception.authexception.*;
import job.Job;

// Niklas und Lisa

public class User extends UserEntity implements UserEntityInfo{

    //all needed variables for user entity

    private String password;
    private String email;
    private String photoUrl;
    private String userId;
    private boolean verifiedAccount;
    private String phoneNumber;
    private UserEntityMetadata metadata;


    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public String getDisplayName() {
        return null;
    }

    @Override
    public String getPhotoUrl() {
        return null;
    }

    @Override
    public String getUserId() {
        return null;
    }

    @Override
    public boolean isEmailVerified() {
        return false;
    }

    @Override
    public String getPhoneNumber() {
        return null;
    }

    @Override
    public UserEntityMetadata getMetadata() {
        return null;
    }

    @Override
    public Job<Void> sendEmailVerification() {
        return null;
    }

    @Override
    public Job<Void> updateEmail(String email) throws AuthInvalidUserException, AuthInvalidCredentialException, AuthUserCollisionException, AuthRecentLoginRequiredException {
        return null;
    }

    //Niklas

    @Override
    public Job<Void> updatePassword(String password) throws AuthWeakPasswordException, AuthInvalidUserException, AuthRecentLoginRequiredException {

        if (password.length() < 6) // Testing purpose -> Password must be at least 6 characters
        {
            throw new AuthWeakPasswordException("1","Password not long enough!");

        }else
        {

        }

        return null;
    }

    @Override
    public Job<Void> updatePhoneNumber(PhoneAuthCredential credential) throws AuthUserCollisionException, AuthInvalidUserException, AuthRecentLoginRequiredException {
        return null;
    }

    @Override
    public Job<Void> verifyBeforeUpdateEmail(String newEmail) {
        return null;
    }

    @Override
    public Job<Void> delete() throws AuthInvalidUserException, AuthRecentLoginRequiredException {
        return null;
    }

    @Override
    public Job<Void> reauthenticate(AuthCredential authCredential) throws AuthInvalidUserException, AuthInvalidCredentialException {
        return null;
    }

    @Override
    public Job<AppAuthResult> reauthenticateAndRetrieveData(AuthCredential authCredential) throws AuthInvalidUserException, AuthInvalidCredentialException {
        return null;
    }

    @Override
    public Job<Void> reload() throws AuthInvalidUserException {
        return null;
    }

    @Override
    public Job<Void> updateProfile(UserEntityProfileChangeRequest request) throws AuthInvalidUserException {
        return null;
    }
}
