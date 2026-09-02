package cz.aegis.corebanking.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transfers")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transfer_id")
    private Long transferId;

    @ManyToOne
    @JoinColumn(name = "source_acc_id")
    private Account sourceAccount;

    @ManyToOne
    @JoinColumn(name = "target_acc_id")
    private Account targetAccount;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "transfer_status")
    private String transferStatus;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Transfer() {
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public Long getTransferId() {
        return transferId;
    }
    public void setTransferId(Long transferId) {
        this.transferId = transferId;
    }

    public Account getSourceAccount() {
        return sourceAccount;
    }
    public void setSourceAccount(Account sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public Account getTargetAccount() {
        return targetAccount;
    }
    public void setTargetAccount(Account targetAccount) {
        this.targetAccount = targetAccount;
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