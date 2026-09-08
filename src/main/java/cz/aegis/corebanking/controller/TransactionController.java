package cz.aegis.corebanking.controller;

import cz.aegis.corebanking.dto.CreateTransactionRequest;
import cz.aegis.corebanking.dto.TransactionResponse;
import cz.aegis.corebanking.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    //endpoint POST - create transaction
    @PostMapping
    public ResponseEntity<TransactionResponse> createTransaction(
            @RequestBody @Valid CreateTransactionRequest request
    ) {
        TransactionResponse response = transactionService.createTransaction(request);

        return ResponseEntity.ok(response);
    }
}