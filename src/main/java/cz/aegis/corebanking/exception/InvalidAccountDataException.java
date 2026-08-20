package cz.aegis.corebanking.exception;

public class InvalidAccountDataException extends RuntimeException {

    public InvalidAccountDataException(String message) {
        super(message);
    }
}
