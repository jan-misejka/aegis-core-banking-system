package cz.aegis.corebanking.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateAccountRequest {

    @NotNull
    private Long clientId;

    @NotBlank
    @Size(max = 16)
    private String accountType;

    @NotBlank
    @Size(max = 3)
    private String currency;

    //Konstruktory
    public CreateAccountRequest() {
    }

    //Gettery a settery
    public Long getClientId() {
        return clientId;
    }
    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getAccountType() {
        return accountType;
    }
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
