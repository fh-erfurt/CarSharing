package archive.main.entity.user;

import archive.main.auth.AppAuthResult;
import archive.main.auth.authcredential.EmailAuthCredential;
import archive.main.auth.authcredential.PhoneAuthCredential;
import archive.main.exception.authexception.*;
import archive.main.job.Job;

// Niklas und Lisa

public class User extends UserEntity implements UserEntityInfo{

    //all needed variables for user archive.main.entity

    private String displayName;
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

        //reauthenticate the user
        try {
            EmailAuthCredential thisUser = new EmailAuthCredential(this.password,this.email);
            reauthenticate(thisUser);
        }
        catch (AuthInvalidUserException invalidUser)
        {
            throw invalidUser;
        }
        catch (AuthInvalidCredentialException invalidCredential)
        {
            throw new AuthInvalidUserException("ERROR_USER_NOT_FOUND", "creating credential has been failed!");
        }

        //test the password for given requirements

        if (password.length() < 6) // Testing purpose -> Password must be at least 6 characters
        {
            throw new AuthWeakPasswordException("ERROR_PASSWORD_SHORT","Password is not long enough!");

        }else
        {
            this.password = password;
            //TODO when archive.main.database is added --> change password for user in archive.main.database
        }

        return null;
    }

    @Override
    public Job<Void> updatePhoneNumber(PhoneAuthCredential credential) throws AuthUserCollisionException, AuthInvalidUserException, AuthRecentLoginRequiredException {

        //reauthenticate the user
        try {
            EmailAuthCredential thisUser = new EmailAuthCredential(this.password,this.email);
            reauthenticate(thisUser);
        }
        catch (AuthInvalidUserException invalidUser)
        {
            throw invalidUser;
        }
        catch (AuthInvalidCredentialException invalidCredential)
        {
            throw new AuthInvalidUserException("ERROR_USER_NOT_FOUND", "creating credential has been failed!");
        }

        //TODO when archive.main.database is added --> check if phonenumber is already in use
        if(!false) //if number is not taken -> for testing
        {
            //TODO when archive.main.database is added --> change phone number in archive.main.database
            this.phoneNumber = credential.getPhoneNumber();
        }
        else
        {
            throw new AuthUserCollisionException("ERROR_PHONE_ALREADY_IN_USE","the requested phonenumber is already in use!");
        }

        return null;
    }

    @Override
    public Job<Void> verifyBeforeUpdateEmail(String newEmail) {

        this.email = newEmail;
        this.sendEmailVerification();
        this.verifiedAccount = false;

        return null;
    }

    @Override
    public Job<Void> delete() throws AuthInvalidUserException, AuthRecentLoginRequiredException {

        //TODO -> when archive.main.database is added

        return null;
    }

    @Override
    public Job<Void> reauthenticate(EmailAuthCredential authCredentialViaEmail) throws AuthInvalidUserException, AuthInvalidCredentialException {

        if (authCredentialViaEmail.getEmail() != null && authCredentialViaEmail.getPassword() != null) {

            // test if email and password is in archive.main.database
            //for testing this will be ignored
            if (authCredentialViaEmail.getEmail() == authCredentialViaEmail.getEmail() && authCredentialViaEmail.getPassword() == authCredentialViaEmail.getPassword()) {

            } else {
                throw new AuthInvalidUserException("ERROR_USER_NOT_FOUND", "email or password not correct!");
            }

        }
        else
        {
            throw new AuthInvalidCredentialException("ERROR_INCOMPLETE_CREDENTIAL","email or password is not set!");
        }

        return null;
    }

    @Override
    public Job<AppAuthResult> reauthenticateAndRetrieveData(EmailAuthCredential authCredentialViaEmail) throws AuthInvalidUserException, AuthInvalidCredentialException {

        try {
            reauthenticate(authCredentialViaEmail);

            //TODO retrieve data

        }
        //handle exceptions
        catch (AuthInvalidUserException invalidUser)
        {
            throw invalidUser;
        }
        catch (AuthInvalidCredentialException invalidCredential)
        {
            throw invalidCredential;
        }

        return null;
    }

    @Override
    public Job<Void> reload() throws AuthInvalidUserException {

        //TODO ?

        return null;
    }

    @Override
    public Job<Void> updateProfile(UserEntityProfileChangeRequest request) throws AuthInvalidUserException {

        try
        {
            //reauthenticate user before applying the changes
            EmailAuthCredential thisUser = new EmailAuthCredential(this.password,this.email);
            reauthenticate(thisUser);

            //check what should be changed
            if (request.getDisplayName() != null)
            {
                this.displayName = request.getDisplayName();
            }

            if (request.getPhotoUrl() != null)
            {
                this.photoUrl = request.getPhotoUrl();
            }

        }
        //handle exceptions
        catch (AuthInvalidUserException invalidUser)
        {
            throw invalidUser;
        }
        catch (AuthInvalidCredentialException invalidCredential)
        {
            throw new AuthInvalidUserException("ERROR_USER_NOT_FOUND", "creating credential has been failed!");
        }

        return null;
    }
}
