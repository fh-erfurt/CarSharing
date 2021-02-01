package model.user;

import task.Task;
import auth.*;
import exception.*;

// this class manages an account's data
public class User implements UserInfo {

    private String displayName, password, email, photoUrl, userId, phoneNumber;
    private boolean verified;
    private UserMetadata metadata;
    private boolean occupied;

    public User(String displayName, String password, String email, String photoUrl, String userId, String phoneNumber) {

        this.displayName = displayName;
        this.password = password;
        this.email = email;
        this.photoUrl = photoUrl;
        this.userId = userId;
        this.phoneNumber = phoneNumber;
        metadata = new UserMetadata();
        this.occupied = false;

    }

    public void startRide()
    {
        this.occupied = true;
    }

    public void endRide()
    {
        this.occupied = false;
    }

    public boolean isOccupied(){
        return this.occupied;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override
    public String getDisplayName() {
        return this.displayName;
    }

    @Override
    public String getPhotoUrl() {
        return this.photoUrl;
    }

    @Override
    public String getUserId() {
        return this.userId;
    }

    @Override
    public boolean isEmailVerified() {
        return false;
    }

    @Override
    public boolean gpsActive() {
        return true; // default set by user device
    }

    public UserMetadata getMetadata() {
        return metadata;
    }

    public Task<Void> sendEmailVerification() {
        return null;
    }

    public Task<Void> reauthenticate(EmailAuthCredential authCredentialViaEmail)
            throws InvalidUserException, InvalidCredentialException {

        if (authCredentialViaEmail.getEmail() != null && authCredentialViaEmail.getPassword() != null) {

            // test if email and password is in archive.main.database
            //for testing this will be ignored
            if (authCredentialViaEmail.getEmail() == authCredentialViaEmail.getEmail() && authCredentialViaEmail.getPassword() == authCredentialViaEmail.getPassword()) {

            } else {
                throw new InvalidUserException("ERROR_USER_NOT_FOUND", "email or password not correct!");
            }

        }
        else
        {
            throw new InvalidCredentialException("ERROR_INCOMPLETE_CREDENTIAL","email or password is not set!");
        }

        return null;
    }

    public Task<AuthResponse> reauthenticateAndRetrieveData(EmailAuthCredential authCredentialViaEmail)
            throws InvalidUserException, InvalidCredentialException {

        try {
            reauthenticate(authCredentialViaEmail);

            //TODO retrieve data

        }
        //handle exceptions
        catch (InvalidUserException invalidUser)
        {
            throw invalidUser;
        }
        catch (InvalidCredentialException invalidCredential)
        {
            throw invalidCredential;
        }

        return null;
    }

    public Task<Void> updateEmail(String email)
            throws InvalidUserException, InvalidCredentialException, UserCollisionException, RecentLoginRequiredException {
        //reauthenticate the user
        try {
            EmailAuthCredential thisUser = new EmailAuthCredential(this.password,this.email);
            reauthenticate(thisUser);
        }
        catch (InvalidUserException invalidUser)
        {
            throw invalidUser;
        }
        catch (InvalidCredentialException invalidCredential)
        {
            throw new InvalidUserException("ERROR_USER_NOT_FOUND", "creating credential has been failed!");
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
                throw new UserCollisionException("ERROR_EMAIL_ALREADY_IN_USE","the requested email-address is already in use!");
            }
        }
        else {
            throw new InvalidCredentialException("ERROR_EMAIL_INVALID", "Email does not have the correct form!");
        }
        return null;
    }

    public Task<Void> updatePhoneNumber(PhoneAuthCredential credential)
            throws UserCollisionException, InvalidUserException, RecentLoginRequiredException {

        //reauthenticate the user
        try {
            EmailAuthCredential thisUser = new EmailAuthCredential(this.password,this.email);
            reauthenticate(thisUser);
        }
        catch (InvalidUserException invalidUser)
        {
            throw invalidUser;
        }
        catch (InvalidCredentialException invalidCredential)
        {
            throw new InvalidUserException("ERROR_USER_NOT_FOUND", "creating credential has been failed!");
        }

        //TODO when archive.main.database is added --> check if phonenumber is already in use
        if(!false) //if number is not taken -> for testing
        {
            //TODO when archive.main.database is added --> change phone number in archive.main.database
            this.phoneNumber = credential.getPhoneNumber();
        }
        else
        {
            throw new UserCollisionException("ERROR_PHONE_ALREADY_IN_USE","the requested phonenumber is already in use!");
        }

        return null;
    }

    public Task<Void> updatePassword(String password)
            throws WeakPasswordException, InvalidUserException, RecentLoginRequiredException {

        //reauthenticate the user
        try {
            EmailAuthCredential thisUser = new EmailAuthCredential(this.password,this.email);
            reauthenticate(thisUser);
        }
        catch (InvalidUserException invalidUser)
        {
            throw invalidUser;
        }
        catch (InvalidCredentialException invalidCredential)
        {
            throw new InvalidUserException("ERROR_USER_NOT_FOUND", "creating credential has been failed!");
        }

        //test the password for given requirements

        if (password.length() < 6) // Testing purpose -> Password must be at least 6 characters
        {
            throw new WeakPasswordException("ERROR_PASSWORD_SHORT","Password is not long enough!");

        }else
        {
            this.password = password;
            //TODO when archive.main.database is added --> change password for user in archive.main.database
        }

        return null;
    }

    public Task<Void> updateProfile(UserProfileChange request)
            throws InvalidUserException {

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
        catch (InvalidUserException invalidUser)
        {
            throw invalidUser;
        }
        catch (InvalidCredentialException invalidCredential)
        {
            throw new InvalidUserException("ERROR_USER_NOT_FOUND", "creating credential has been failed!");
        }

        return null;
    }
}
