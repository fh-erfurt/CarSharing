package exception.authexception;

import exception.AppException;

public class AuthException extends AppException {
    public AuthException(String errorCode, String message){
        super(message);
    }
    public String getErrorCode(){
        return null;
    }
}
