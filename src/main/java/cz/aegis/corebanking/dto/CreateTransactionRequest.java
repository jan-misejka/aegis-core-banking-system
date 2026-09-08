package cz.aegis.corebanking.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class CreateTransactionRequest {

    @NotNull
    private Long accountId;

    @NotNull
    private String type;

    @NotNull
    @DecimalMin(value = "0.01")
    private BigDecimal amount;

    //Konstruktor
    public CreateTransactionRequest() {
    }

    //Gettery a settery
    public Long getAccountId() {
        return accountId;
    }
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
