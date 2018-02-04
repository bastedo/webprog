package core.services.exceptions;

public class PraviloExistsException extends RuntimeException{
    public PraviloExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public PraviloExistsException(String message) {
        super(message);
    }

    public PraviloExistsException() {
        super();
    }
}
