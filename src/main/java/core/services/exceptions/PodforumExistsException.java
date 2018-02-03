package core.services.exceptions;

public class PodforumExistsException extends RuntimeException  {
    public PodforumExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public PodforumExistsException(String message) {
        super(message);
    }

    public PodforumExistsException() {
        super();
    }
}
