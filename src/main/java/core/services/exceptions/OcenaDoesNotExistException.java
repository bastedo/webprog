package core.services.exceptions;


public class OcenaDoesNotExistException extends RuntimeException  {
    public OcenaDoesNotExistException(Throwable cause) {
        super(cause);
    }

    public OcenaDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public OcenaDoesNotExistException(String message) {
        super(message);
    }

    public OcenaDoesNotExistException() {
        super();
    }
}