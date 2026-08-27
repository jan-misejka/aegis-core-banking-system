package cz.aegis.corebanking.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class DepositMoneyRequest {

    @DecimalMin(value = "0.01")
    @NotNull
    private BigDecimal amount;

    //Konstruktory
    public DepositMoneyRequest() {
    }

    //Gettery a settery
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}