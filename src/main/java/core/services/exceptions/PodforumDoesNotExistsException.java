package core.services.exceptions;

public class PodforumDoesNotExistsException extends RuntimeException {
    public PodforumDoesNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public PodforumDoesNotExistsException(String message) {
        super(message);
    }

    public PodforumDoesNotExistsException() {
        super();
    }
}
