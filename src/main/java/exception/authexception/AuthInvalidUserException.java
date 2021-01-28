package exception.authexception;

public final class AuthInvalidUserException extends AuthException{
    public AuthInvalidUserException(String errorCode, String message) {
        super(errorCode, message);
    }
}
