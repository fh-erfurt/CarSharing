package service.exception;

public class ServiceException extends Exception {
    private final String message;

    public ServiceException(String exceptionMessage) {
        this.message = exceptionMessage;
    }

    public ServiceException(String exceptionMessage, Throwable cause) {
        this.message = exceptionMessage;
    }
}
