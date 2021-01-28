package exception.authexception;

public class AuthWeakPasswordException extends AuthException{
    public AuthWeakPasswordException(String errorCode, String message) {
        super(errorCode, message);
    }
}