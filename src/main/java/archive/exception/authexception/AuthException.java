package exception.authexception;

import exception.AppException;

// Generic exception related to App Authentication.
public class AuthException extends AppException {
    public AuthException(String errorCode, String message){
        super(message);
    }
    public String getErrorCode(){
        return null;
    }
}
