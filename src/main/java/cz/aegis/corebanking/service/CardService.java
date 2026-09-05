package cz.aegis.corebanking.service;

import cz.aegis.corebanking.dto.CardResponse;
import cz.aegis.corebanking.dto.CreateCardRequest;
import cz.aegis.corebanking.entity.Account;
import cz.aegis.corebanking.entity.Card;
import cz.aegis.corebanking.exception.AccountNotFoundException;
import cz.aegis.corebanking.exception.CardAlreadyBlockedException;
import cz.aegis.corebanking.exception.CardNotFoundException;
import cz.aegis.corebanking.exception.ExpiredCardException;
import cz.aegis.corebanking.repository.AccountRepository;
import cz.aegis.corebanking.repository.CardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CardService {

    private final CardRepository cardRepository;
    private final AccountRepository accountRepository;

    public CardService(
            CardRepository cardRepository,
            AccountRepository accountRepository
    ) {
        this.cardRepository = cardRepository;
        this.accountRepository = accountRepository;
    }

    //Metoda pro vydání karty
    @Transactional
    public CardResponse createCard(CreateCardRequest request) {

        Account account = accountRepository.findById(request.getAccountId())
                .orElseThrow(() -> new AccountNotFoundException(request.getAccountId()));

        String cardNumber = generateUniqueCardNumber();

        Card card = new Card();

        card.setAccount(account);
        card.setCardNumber(cardNumber);
        card.setCardStatus("ACTIVE");
        card.setExpiryDate(LocalDate.now().plusYears(10));

        Card savedCard = cardRepository.save(card);

        CardResponse response = new CardResponse();

        response.setCardId(savedCard.getCardId());
        response.setAccountId(savedCard.getAccount().getAccountId());
        response.setCardNumber(savedCard.getCardNumber());
        response.setCardStatus(savedCard.getCardStatus());
        response.setExpiryDate(savedCard.getExpiryDate());
        response.setCreatedAt(savedCard.getCreatedAt());

        return response;
    }

    //Metoda pro zablokování karty
    @Transactional
    public CardResponse blockCard(Long cardId) {

        Card card = cardRepository.findById(cardId).orElseThrow(() -> new CardNotFoundException(cardId));
        if ("BLOCKED".equals(card.getCardStatus())) {
            throw new CardAlreadyBlockedException(cardId);
        }
        if ("EXPIRED".equals(card.getCardStatus())) {
            throw new ExpiredCardException(cardId);
        }

        card.setCardStatus("BLOCKED");

        Card savedCard = cardRepository.save(card);

        CardResponse response = new CardResponse();

        response.setCardId(savedCard.getCardId());
        response.setAccountId(savedCard.getAccount().getAccountId());
        response.setCardNumber(savedCard.getCardNumber());
        response.setCardStatus(savedCard.getCardStatus());
        response.setExpiryDate(savedCard.getExpiryDate());
        response.setCreatedAt(savedCard.getCreatedAt());

        return response;
    }

    //Metoda pro generování unique čísla karty
    private String generateUniqueCardNumber() {

        while (true) {
            String cardNumber = generateCardNumber();

            if (!cardRepository.existsByCardNumber(cardNumber)) {
                return cardNumber;
            }
        }
    }

    //Metoda pro generování čísla karty
    private String generateCardNumber() {

        StringBuilder cardNumber = new StringBuilder("4");

        for (int i = 1; i < 16; i++) {

            cardNumber.append(ThreadLocalRandom.current().nextInt(10));
        }

        return cardNumber.toString();
    }
}