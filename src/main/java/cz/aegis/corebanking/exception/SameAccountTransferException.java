package cz.aegis.corebanking.exception;

public class SameAccountTransferException extends RuntimeException {

    public SameAccountTransferException() {
        super("Source and target account cannot be the same.");
    }
}
