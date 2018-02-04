package core.services.exceptions;

public class PraviloDoesNotExistException extends RuntimeException  {
    public PraviloDoesNotExistException(Throwable cause) {
        super(cause);
    }

    public PraviloDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public PraviloDoesNotExistException(String message) {
        super(message);
    }

    public PraviloDoesNotExistException() {
        super();
    }
}
