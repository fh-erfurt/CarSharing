package service.exception;

public class ServiceAuthException extends ServiceException {
    private final String errorCode;

    public ServiceAuthException(String errorCode, String exceptionMessage) {
        super(exceptionMessage);
        this.errorCode = errorCode;
    }

    public String getErrorCode(){
        return this.errorCode;
    }
}
