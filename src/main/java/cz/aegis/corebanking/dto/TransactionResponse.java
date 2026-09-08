package cz.aegis.corebanking.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionResponse {

    private Long transactionId;
    private Long accountId;
    private String transactionType;
    private BigDecimal amount;
    private LocalDateTime createdAt;

    public TransactionResponse() {
    }

    public TransactionResponse(Long transactionId, Long accountId, String transactionType, BigDecimal amount, LocalDateTime createdAt) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.createdAt = createdAt;
    }

    public Long getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getAccountId() {
        return accountId;
    }
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getTransactionType() {
        return transactionType;
    }
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}