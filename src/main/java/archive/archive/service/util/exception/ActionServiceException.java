package archive.service.util.exception;

public class ActionServiceException extends Exception {
    private final String message;

    public ActionServiceException(String exceptionMessage) {
        this.message = exceptionMessage;
    }

    public ActionServiceException(String exceptionMessage, Throwable cause) {
        this.message = exceptionMessage;
    }
}
