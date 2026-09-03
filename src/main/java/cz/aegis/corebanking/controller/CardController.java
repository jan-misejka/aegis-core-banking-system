package cz.aegis.corebanking.controller;

import cz.aegis.corebanking.dto.CardResponse;
import cz.aegis.corebanking.dto.CreateCardRequest;
import cz.aegis.corebanking.service.CardService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    //endpoint POST - pro vydání karty
    @PostMapping
    public ResponseEntity<CardResponse> createCard(@RequestBody @Valid CreateCardRequest request) {

        CardResponse response = cardService.createCard(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}