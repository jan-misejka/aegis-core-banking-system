package cz.aegis.corebanking.exception;

public class InvalidTransactionTypeException extends RuntimeException{

    public InvalidTransactionTypeException(String transactionType) {
        super("Invalid transaction type: " + transactionType);
    }
}