package core.services.exceptions;

public class PorukaDoesNotExistException extends RuntimeException  {
    public PorukaDoesNotExistException(Throwable cause) {
        super(cause);
    }

    public PorukaDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public PorukaDoesNotExistException(String message) {
        super(message);
    }

    public PorukaDoesNotExistException() {
        super();
    }
}