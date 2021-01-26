package exception.authexception;

public final class AuthInvalidEntityException extends AuthException{
    public AuthInvalidEntityException(String errorCode, String message) {
        super(errorCode, message);
    }
}
