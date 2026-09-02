package cz.aegis.corebanking.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class TransferMoneyRequest {

    @NotNull
    private Long sourceAccountId;

    @NotNull
    private Long targetAccountId;

    @DecimalMin(value = "0.01")
    @NotNull
    private BigDecimal amount;

    //Konstruktor
    public TransferMoneyRequest() {
    }

    //Gettery a settery
    public Long getSourceAccountId() {
        return sourceAccountId;
    }
    public void setSourceAccountId(Long sourceAccountId) {
        this.sourceAccountId = sourceAccountId;
    }

    public Long getTargetAccountId() {
        return targetAccountId;
    }
    public void setTargetAccountId(Long targetAccountId) {
        this.targetAccountId = targetAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
