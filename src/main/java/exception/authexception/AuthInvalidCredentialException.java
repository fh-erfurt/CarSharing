package exception.authexception;

public class AuthInvalidCredentialException extends AuthException {
    public AuthInvalidCredentialException(String errorCode, String message) {
        super(errorCode, message);
    }
}