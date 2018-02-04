package core.services.exceptions;

public class ZalbaDoesNotExistException extends RuntimeException  {
    public ZalbaDoesNotExistException(Throwable cause) {
        super(cause);
    }

    public ZalbaDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public ZalbaDoesNotExistException(String message) {
        super(message);
    }

    public ZalbaDoesNotExistException() {
        super();
    }
}