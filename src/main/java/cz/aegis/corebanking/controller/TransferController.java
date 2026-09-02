package cz.aegis.corebanking.controller;

import cz.aegis.corebanking.dto.TransferMoneyRequest;
import cz.aegis.corebanking.dto.TransferResponse;
import cz.aegis.corebanking.service.TransferService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfers")
public class TransferController {

    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    //endpoint POST - transfer
    @PostMapping
    public ResponseEntity<TransferResponse> transferMoney(@RequestBody @Valid TransferMoneyRequest request) {

        TransferResponse response = transferService.transferMoney(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}