package exception;

public class BookingTokenExpiredException extends SuperException{
    public BookingTokenExpiredException(String errorCode, String message){
        super(message);
    }
    public String getErrorCode(){
        return null;
    }
}
