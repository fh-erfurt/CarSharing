package exception;

public class AuthEntityCollisionException extends AuthException{
    public AuthEntityCollisionException(String errorCode, String message) {
        super(errorCode, message);
    }
}
