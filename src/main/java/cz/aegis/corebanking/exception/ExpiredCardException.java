package cz.aegis.corebanking.exception;

public class ExpiredCardException extends RuntimeException {

    public ExpiredCardException(Long cardId) {
        super("Card with ID: " + cardId + " is expired.");
    }
}