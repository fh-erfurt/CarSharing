package archive.main.exception.authexception;

// Represents the archive.main.exception which is a result of an expired or an invalid out of band code.
public class AuthActionCodeException extends AuthException{
    public AuthActionCodeException(String errorCode, String message) {
        super(errorCode, message);
    }
}
