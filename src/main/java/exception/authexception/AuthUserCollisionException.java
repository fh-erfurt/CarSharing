package exception.authexception;

public class AuthUserCollisionException extends AuthException{
    public AuthUserCollisionException(String errorCode, String message) {
        super(errorCode, message);
    }
}
