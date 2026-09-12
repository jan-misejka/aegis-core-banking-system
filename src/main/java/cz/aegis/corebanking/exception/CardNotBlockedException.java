package cz.aegis.corebanking.exception;

public class CardNotBlockedException extends RuntimeException {

    public CardNotBlockedException(Long cardId) {
        super("Card with ID: " + cardId + " not blocked.");
    }
}