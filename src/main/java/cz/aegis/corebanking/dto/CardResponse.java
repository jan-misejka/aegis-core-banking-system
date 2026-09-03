package cz.aegis.corebanking.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CardResponse {

    private Long cardId;
    private Long accountId;
    private String cardNumber;
    private String cardStatus;
    private LocalDate expiryDate;
    private LocalDateTime createdAt;

    //Konstruktory
    public CardResponse() {
    }

    public CardResponse(Long cardId, Long accountId, String cardNumber,
                        String cardStatus, LocalDate expiryDate, LocalDateTime createdAt) {
        this.cardId = cardId;
        this.accountId = accountId;
        this.cardNumber = cardNumber;
        this.cardStatus = cardStatus;
        this.expiryDate = expiryDate;
        this.createdAt = createdAt;
    }

    //Gettery a settery
    public Long getCardId() {
        return cardId;
    }
    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public Long getAccountId() {
        return accountId;
    }
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardStatus() {
        return cardStatus;
    }
    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
