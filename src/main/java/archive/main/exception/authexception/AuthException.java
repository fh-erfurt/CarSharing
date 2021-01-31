package archive.main.exception.authexception;

import archive.main.exception.AppException;

// Generic archive.main.exception related to App Authentication.
public class AuthException extends AppException {
    public AuthException(String errorCode, String message){
        super(message);
    }
    public String getErrorCode(){
        return null;
    }
}
