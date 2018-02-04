package core.services.exceptions;

public class KomentarDoesNotExistException extends RuntimeException {
    public KomentarDoesNotExistException(Throwable cause) {
        super(cause);
    }

    public KomentarDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public KomentarDoesNotExistException(String message) {
        super(message);
    }

    public KomentarDoesNotExistException() {
        super();
    }
}