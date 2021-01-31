package exception;

public class InvalidUserException extends AuthException {
    public InvalidUserException(String errorCode, String message) {
        super(errorCode, message);
    }
}
