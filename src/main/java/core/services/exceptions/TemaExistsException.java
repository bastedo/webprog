package core.services.exceptions;

public class TemaExistsException extends RuntimeException{
    public TemaExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public TemaExistsException(String message) {
        super(message);
    }

    public TemaExistsException() {
        super();
    }
}
