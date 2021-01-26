package archive.service.util.exception;

public class AuthServiceException extends ActionServiceException {
    private final String errorCode;

    public AuthServiceException(String errorCode, String exceptionMessage) {
        super(exceptionMessage);
        this.errorCode = errorCode;
    }

    public String getErrorCode(){
        return this.errorCode;
    }
}
