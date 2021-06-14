package util;

/**
 * invalid data exception class, extends Exception
 */

public class InvalidDataException extends Exception {

    /**
     * constructor
     */

    public InvalidDataException () {

    }

    /**
     * constructor
     *
     * @param message - error message
     */

    public InvalidDataException (String message) {
        super (message);
    }

    /**
     * constructor
     *
     * @param cause - cause of error
     */

    public InvalidDataException (Throwable cause) {
        super (cause);
    }

    /**
     * constructor
     *
     * @param message - error message
     * @param cause - cause of error
     */

    public InvalidDataException (String message, Throwable cause) {
        super (message, cause);
    }
}
