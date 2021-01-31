package exception;

public class WeakPasswordException extends AuthException {

    public WeakPasswordException(String errorCode, String message) {
        super(errorCode, message);
    }
}
