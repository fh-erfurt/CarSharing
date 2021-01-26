package exception.authexception;

public class AuthAccessCodeException extends AuthException{
    public AuthAccessCodeException(String errorCode, String message) {
        super(errorCode, message);
    }
}
