package archive.main.exception.authexception;

// Thrown on security sensitive operations on a User instance that require the user
// to have signed in recently, when the requirement isn't met.
//
//Resolve this archive.main.exception by asking the user for their credentials again,
// and verifying them by calling User.reauthenticate(AuthCredential).
public final class AuthRecentLoginRequiredException extends AuthException{
    public AuthRecentLoginRequiredException(String errorCode, String message) {
        super(errorCode, message);
    }
}
