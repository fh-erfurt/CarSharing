package exception;

public class InvalidCredentialException extends AuthException {

    public InvalidCredentialException(String errorCode, String message) {
        super(errorCode, message);
    }
}
