package exception;

public class UserCollisionException extends AuthException {

    public UserCollisionException(String errorCode, String message) {
        super(errorCode, message);
    }
}
