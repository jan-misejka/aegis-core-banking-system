package cz.aegis.corebanking.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class WithdrawMoneyRequest {

    @DecimalMin(value = "0.01")
    @NotNull
    private BigDecimal amount;

    //Konstruktory
    public WithdrawMoneyRequest() {
    }

    //Gettery a settery
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
