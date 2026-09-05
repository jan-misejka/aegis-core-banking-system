package cz.aegis.corebanking.exception;

public class CardAlreadyBlockedException extends RuntimeException {

    public CardAlreadyBlockedException(Long cardId) {
        super("Card with ID " + cardId + " is already blocked.");
    }
}