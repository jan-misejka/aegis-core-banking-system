package cz.aegis.corebanking.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransferResponse {

    private Long transferId;
    private Long sourceAccountId;
    private Long targetAccountId;
    private BigDecimal amount;
    private String transferStatus;
    private LocalDateTime createdAt;

    //Konstruktor
    public TransferResponse() {
    }

    //Gettery a settery
    public Long getTransferId() {
        return transferId;
    }
    public void setTransferId(Long transferId) {
        this.transferId = transferId;
    }

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

    public String getTransferStatus() {
        return transferStatus;
    }
    public void setTransferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
