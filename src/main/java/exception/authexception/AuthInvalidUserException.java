package exception.authexception;

// Thrown when performing an operation on a User instance that is no longer valid.
//
//This could happen in the following cases:
//
//ERROR_USER_DISABLED if the user has been disabled
//ERROR_USER_NOT_FOUND if the user has been deleted (for example, in another instance of this app)
//ERROR_USER_TOKEN_EXPIRED if the user's token has been revoked in the backend.
// This happens automatically if the user's credentials change in another device
// (for example, on a password change event).
//ERROR_INVALID_USER_TOKEN if the user's token is malformed.
// This should not happen under normal circumstances.
public final class AuthInvalidUserException extends AuthException{
    public AuthInvalidUserException(String errorCode, String message) {
        super(errorCode, message);
    }
}
