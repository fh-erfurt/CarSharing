package archive.main.exception.authexception;

// Thrown when one or more of the credentials passed to a method
// fail to identify and/or authenticate the user subject of that operation.
// Inspect the error code and message to find out the specific cause.
public class AuthInvalidCredentialException extends AuthException {
    public AuthInvalidCredentialException(String errorCode, String message) {
        super(errorCode, message);
    }
}
