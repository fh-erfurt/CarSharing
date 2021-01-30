package entity.user;

import auth.AppAuthResult;
import auth.authcredential.AuthCredential;
import auth.authcredential.EmailAuthCredential;
import auth.authcredential.PhoneAuthCredential;
import exception.authexception.*;
import job.Job;

public abstract class UserEntity implements UserEntityInfo {
    public UserEntity() {

    }

    // Returns the main email address of the user, as stored in the database.
    // this email address can be updated at any time by calling updateEmail(String).
    public abstract String getEmail();

    // Returns the main display name of this user from the database.
    // this name can be updated at any time by calling updateProfile(UserEntityProfileChangeRequest).
    public abstract String getDisplayName();

    // Returns the URL of this user's main profile picture, as stored in the database.
    // this URL can be updated at any time by calling updateProfile(UserEntityProfileChangeRequest).
    public abstract String getPhotoUrl();

    // Returns a string used to uniquely identify the user in the database.
    public abstract String getUserId();

    // Returns the phone number of the user, as stored in the database, or null if none exists.
    // can be updated at any time by calling updatePhoneNumber(PhoneAuthCredential).
    public abstract String getPhoneNumber();

    // Fetches a Auth ID Token for the user; useful when authenticating against time restricted access (30-min buffer period).
    // InvalidUserException thrown if the current user's account has been disabled, deleted, or its credentials are no longer valid.
    // forceRefresh force refreshes the token. Should only be set to true if the token is invalidated out of band.
    // beta feature
    /*public Job<IdTokenResult> getAuthIdToken (boolean forceRefresh) throws AuthInvalidUserException {
        return null;
    }*/

    // Returns the UserMetadata associated with this user.
    public abstract UserEntityMetadata getMetadata();

    // Initiates email verification for the user.
    // Returns Job to track completion of the sending operation.
    public abstract Job<Void> sendEmailVerification();

    // Updates the email address of the user.
    // Important: this is a security sensitive operation that requires the user to have recently signed in.
    // If this requirement isn't met, ask the user to authenticate again and later call reauthenticate(AuthCredential).
    // In addition, note that the original email address recipient will receive an email
    // that allows them to revoke the email address change, in order to protect them from account hijacking.
    // AuthInvalidCredentialsException thrown if the email address is malformed
    // AuthUserCollisionException thrown if there already exists an account with the given email address
    // AuthInvalidUserException thrown if the current user's account has been disabled, deleted, or its credentials are no longer valid
    // AuthRecentLoginRequiredException thrown if the user's last sign-in time does not meet the security threshold.
    // Use reauthenticate(AuthCredential) to resolve.
    public abstract Job<Void> updateEmail (String email) throws AuthInvalidUserException, AuthInvalidCredentialException, AuthUserCollisionException, AuthRecentLoginRequiredException;

    // Updates the password of the user.
    // Important: this is a security sensitive operation that requires the user to have recently signed in.
    // If this requirement isn't met, ask the user to authenticate again and later call reauthenticate(AuthCredential).
    // AuthWeakPasswordException thrown if the password is not strong enough
    // AuthInvalidUserException thrown if the current user's account has been disabled, deleted, or its credentials are no longer valid
    // AuthRecentLoginRequiredException thrown if the user's last sign-in time does not meet the security threshold.
    // Use reauthenticate(AuthCredential) to resolve.
    public abstract Job<Void> updatePassword(String password) throws AuthWeakPasswordException, AuthInvalidUserException, AuthRecentLoginRequiredException;

    // Updates the phone number of the user.
    // Important: this is a security sensitive operation that requires the user to have recently signed in.
    // If this requirement isn't met, ask the user to authenticate again and later call reauthenticate(AuthCredential).
    // AuthUserCollisionException thrown if there already exists an account with the given phone number
    // AuthInvalidUserException thrown if the current user's account has been disabled, deleted, or its credentials are no longer valid
    // AuthRecentLoginRequiredException thrown if the user's last sign-in time does not meet the security threshold.
    // Use reauthenticate(AuthCredential) to resolve.
    public abstract Job<Void> updatePhoneNumber(PhoneAuthCredential credential) throws AuthUserCollisionException, AuthInvalidUserException, AuthRecentLoginRequiredException;

    // Sends a verification email to newEmail.
    // Upon redemption of the link in the email, this user's email will be changed to newEmail and that email will be marked verified.
    // newEmail	the user's new email
    // Returns Job to track completion of the sending operation.
    public abstract Job<Void> verifyBeforeUpdateEmail(String newEmail);

    // Deletes the user record from your Firebase project's database. If the operation is successful, the user will be signed out.
    // this is a security sensitive operation that requires the user to have recently signed in.
    // If this requirement isn't met, ask the user to authenticate again and later call reauthenticate(AuthCredential).
    // InvalidUserException thrown if the current user's account has been disabled, deleted, or its credentials are no longer valid
    // AuthRecentLoginRequiredException thrown if the user's last sign-in time does not meet the security threshold.
    // Use reauthenticate(AuthCredential) to resolve.
    public abstract Job<Void> delete() throws AuthInvalidUserException, AuthRecentLoginRequiredException;

    // Re-authenticates the user with the given credential.
    // This is useful for operations that require a recent sign-in, to prevent or resolve a AuthRecentLoginRequiredException.
    // AuthInvalidUserException thrown if the current user's account has been disabled or deleted
    // AuthInvalidCredentialsException thrown if the credential is malformed or has expired,
    // or if it corresponds to another existing user's account.
    // Inspect the error code to disambiguate.
    // credential-authentication credential that must be valid for the current user.
    public abstract Job<Void> reauthenticate(EmailAuthCredential authCredential) throws AuthInvalidUserException, AuthInvalidCredentialException;

    // Re-authenticates the user with the given credential, and returns the profile data for that account.
    // This is useful for operations that require a recent sign-in, to prevent or resolve a AuthRecentLoginRequiredException.
    // AuthInvalidUserException thrown if the current user's account has been disabled or deleted
    // AuthInvalidCredentialsException thrown if the credential is malformed or has expired,
    // or if it corresponds to another existing user's account.
    // Inspect the error code to disambiguate.
    // Returns AuthResult containing the User reference and AdditionalUserInfo.
    public abstract Job<AppAuthResult> reauthenticateAndRetrieveData(EmailAuthCredential authCredential) throws AuthInvalidUserException, AuthInvalidCredentialException;

    // Manually refreshes the data of the current user (for example, display name, and so on).
    // AuthInvalidUserException thrown if the current user's account has been disabled, deleted, or its credentials are no longer valid
    public abstract Job<Void> reload() throws AuthInvalidUserException;

    // Updates the user profile information. Use UserProfileChangeRequest.Builder to construct the request.
    // AuthInvalidUserException thrown if the current user's account has been disabled, deleted, or its credentials are no longer valid
    public abstract Job<Void> updateProfile(UserEntityProfileChangeRequest request) throws AuthInvalidUserException;

}
