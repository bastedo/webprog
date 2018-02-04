package core.services.exceptions;

public class KomentarExistsException extends RuntimeException {
    public KomentarExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public KomentarExistsException(String message) {
        super(message);
    }

    public KomentarExistsException() {
        super();
    }
}