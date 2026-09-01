package cz.aegis.corebanking.exception;

import java.math.BigDecimal;

public class InsufficientBalanceException extends RuntimeException {

    public InsufficientBalanceException(BigDecimal requestedAmount, BigDecimal currentBalance) {
        super("Insufficient balance. Requested: " + requestedAmount + ", current balance: " + currentBalance);
    }
}