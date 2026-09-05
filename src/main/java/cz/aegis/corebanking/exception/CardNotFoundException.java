package cz.aegis.corebanking.exception;

public class CardNotFoundException extends RuntimeException {

    public CardNotFoundException(Long cardId) {
        super("Card with ID: " + cardId + " not found.");
    }
}