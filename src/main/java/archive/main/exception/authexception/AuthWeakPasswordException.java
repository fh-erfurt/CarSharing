package archive.main.exception.authexception;

// Thrown when using a weak password (less than 6 chars) to create a new account or to update an existing account's password. Use getReason() to get a message with the reason the validation failed that you can display to your users.
public class AuthWeakPasswordException extends AuthInvalidCredentialException{
    public AuthWeakPasswordException(String errorCode, String message) {
        super(errorCode, message);
    }
    // Returns a message that contains the reason that the password strength validation failed.
    // This message can be directly shown to the user.
    public String getReason() {
        return null;
    }
}
