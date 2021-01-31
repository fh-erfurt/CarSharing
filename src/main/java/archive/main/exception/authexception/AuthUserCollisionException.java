package archive.main.exception.authexception;

// Thrown when an operation on a User instance couldn't be completed
// due to a conflict with another existing user.
//
//This could happen in the following cases:
//
//ERROR_PHONE_ALREADY_IN_USE when trying to create a new account with
// if the phone number is already in use by a different account
//ERROR_EMAIL_ALREADY_IN_USE when trying to create a new account with
// Auth.createUserWithEmailAndPassword(String, String) or to change a user's email address,
// if the email is already in use by a different account
//ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL when calling
// Auth.signInWithCredential(AuthCredential)
// with a credential that asserts an email address in use by another account.
// This error will only be thrown if the "One account per email address" setting is
// enabled (recommended).
//ERROR_CREDENTIAL_ALREADY_IN_USE when trying to link a user with an
// AuthCredential corresponding to another account already in use.
//Inspect the error code and message to find out the specific cause.
//Resolve this archive.main.exception by asking the user to sign in again with valid credentials.
// In the case that this is thrown when using a PhoneAuthCredential,
// you can retrieve an updated credential from getUpdatedCredential() and use it to sign-in.
public class AuthUserCollisionException extends AuthException{
    public AuthUserCollisionException(String errorCode, String message) {
        super(errorCode, message);
    }
}
