package exception.authexception;

// Represents the exception which is a result of an already existing account
public class AuthEntityCollisionException extends AuthException{
    public AuthEntityCollisionException(String errorCode, String message) {
        super(errorCode, message);
    }
}
