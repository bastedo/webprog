package core.services.exceptions;

public class TemaDoesNotExistException extends RuntimeException  {
    public TemaDoesNotExistException(Throwable cause) {
        super(cause);
    }

    public TemaDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public TemaDoesNotExistException(String message) {
        super(message);
    }

    public TemaDoesNotExistException() {
        super();
    }
}