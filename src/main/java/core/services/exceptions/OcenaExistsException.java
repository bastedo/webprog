package core.services.exceptions;

public class OcenaExistsException extends RuntimeException{
    public OcenaExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public OcenaExistsException(String message) {
        super(message);
    }

    public OcenaExistsException() {
        super();
    }
}
