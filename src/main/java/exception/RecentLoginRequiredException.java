package exception;

public class RecentLoginRequiredException extends AuthException{

    public RecentLoginRequiredException(String errorCode, String message) {
        super(errorCode, message);
    }
}
