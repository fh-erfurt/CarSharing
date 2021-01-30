package entity.user;

import auth.AppAuthResult;
import auth.authcredential.AuthCredential;
import auth.authcredential.EmailAuthCredential;
import auth.authcredential.PhoneAuthCredential;
import exception.authexception.*;
import job.Job;

// Niklas und Lisa

public class User extends UserEntity implements UserEntityInfo{

    //all needed variables for user entity

    private String displayName;
    private String password;
    private String email;
    private String photoUrl;
    private String userId;
    private boolean verifiedAccount;
    private String phoneNumber;
    private UserMetadata metadata;


    //TODO when database is added --> get email from database
    @Override
    public String getEmail() {

        return email;
    }

    //TODO when database is added --> get displayName from database
    @Override
    public String getDisplayName() {

        return displayName;
    }

    //TODO when database is added --> get photoUrl from database
    @Override
    public String getPhotoUrl() {

        return photoUrl;
    }

    //TODO when database is added --> get userId from database
    @Override
    public String getUserId() {

        return userId;
    }

    @Override
    public boolean isEmailVerified() {

        return verifiedAccount;
    }

    //TODO when database is added --> get phoneNumber from database
    @Override
    public String getPhoneNumber() {

        return phoneNumber;
    }

    @Override
    public UserEntityMetadata getMetadata() {

        return metadata;
    }

    @Override
    public Job<Void> sendEmailVerification() {
        return null;
    }

    @Override
    public Job<Void> updateEmail(String email) throws AuthInvalidUserException, AuthInvalidCredentialException, AuthUserCollisionException, AuthRecentLoginRequiredException {

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

        // easier regex to test if email is valid
        // needs to be modified for more security!
        String emailRegex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

        // test if new email is valid
        if (email.matches(emailRegex)) {
            //test if email is already taken by another account
            // for testing, email is not in use
            if(!false)
            {
                //TODO when database is added --> change email in database
                this.email = email;
            }
            else
            {
                throw new AuthUserCollisionException("ERROR_EMAIL_ALREADY_IN_USE","the requested email-address is already in use!");
            }
        }
        else {
            throw new AuthInvalidCredentialException("ERROR_EMAIL_INVALID", "Email does not have the correct form!");
        }

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
            //TODO when database is added --> change password for user in database
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

        //TODO when database is added --> check if phonenumber is already in use
        if(!false) //if number is not taken -> for testing
        {
            //TODO when database is added --> change phone number in database
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

        //TODO -> when database is added

        return null;
    }

    @Override
    public Job<Void> reauthenticate(EmailAuthCredential authCredentialViaEmail) throws AuthInvalidUserException, AuthInvalidCredentialException {

        if (authCredentialViaEmail.getEmail() != null && authCredentialViaEmail.getPassword() != null) {

            // test if email and password is in database
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
