package core.services.exceptions;

public class PorukaExistsException extends RuntimeException  {
    public PorukaExistsException(Throwable cause) {
        super(cause);
    }

    public PorukaExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public PorukaExistsException(String message) {
        super(message);
    }

    public PorukaExistsException() {
        super();
    }
}
