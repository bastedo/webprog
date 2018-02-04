package core.services.exceptions;

public class ZalbaExistsException extends RuntimeException{
    public ZalbaExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ZalbaExistsException(String message) {
        super(message);
    }

    public ZalbaExistsException() {
        super();
    }
}
