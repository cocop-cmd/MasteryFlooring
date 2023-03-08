package Service;

public class StateValidationException extends Exception{

    StateValidationException(String message) {
        super(message);
    }

    StateValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
