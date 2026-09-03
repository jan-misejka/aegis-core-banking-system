package cz.aegis.corebanking.dto;

import jakarta.validation.constraints.NotNull;

public class CreateCardRequest {

    @NotNull
    private Long accountId;

    public CreateCardRequest() {
    }

    public Long getAccountId() {
        return accountId;
    }
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}