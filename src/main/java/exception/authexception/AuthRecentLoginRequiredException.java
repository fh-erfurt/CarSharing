package exception.authexception;

public final class AuthRecentLoginRequiredException extends AuthException{
    public AuthRecentLoginRequiredException(String errorCode, String message) {
        super(errorCode, message);
    }
}
