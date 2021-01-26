package exception.authexception;

import exception.SuperException;

public class AuthException extends SuperException {
    public AuthException(String errorCode, String message){
        super(message);
    }
    public String getErrorCode(){
        return null;
    }
}
