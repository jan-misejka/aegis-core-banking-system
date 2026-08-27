package cz.aegis.corebanking.controller;

import cz.aegis.corebanking.dto.AccountResponse;
import cz.aegis.corebanking.dto.CreateAccountRequest;
import cz.aegis.corebanking.dto.DepositMoneyRequest;
import cz.aegis.corebanking.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //endpoint POST
    @PostMapping
    public ResponseEntity<AccountResponse> createAccount(@RequestBody @Valid CreateAccountRequest request) {

        AccountResponse response = accountService.createAccount(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //endpoint POST - deposit
    @PostMapping("/{id}/deposit")
    public ResponseEntity<AccountResponse> depositMoney(@PathVariable Long id, @RequestBody @Valid DepositMoneyRequest request) {

        AccountResponse response = accountService.depositMoney(id, request);

        return ResponseEntity.ok(response);
    }
}