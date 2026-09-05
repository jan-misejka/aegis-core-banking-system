package cz.aegis.corebanking.controller;

import cz.aegis.corebanking.TestDatabaseReset;
import cz.aegis.corebanking.entity.Card;
import cz.aegis.corebanking.repository.CardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
public class CardControllerTest extends TestDatabaseReset {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CardRepository cardRepository;

    //Pozitivní testy:
    //Úspěšné vydání karty
    @Test
    void shouldIssueCardSuccessfully() throws Exception {

        long initialCardCount = cardRepository.count();

        LocalDateTime beforeRequest = LocalDateTime.now();

        mockMvc.perform(post("/cards")
                        .contentType(APPLICATION_JSON)
                        .content("""
                        {
                            "accountId": 15
                        }
                        """))
                .andExpect(status().isCreated());

        LocalDateTime afterRequest = LocalDateTime.now();

        assertEquals(initialCardCount + 1, cardRepository.count());

        Card savedCard = cardRepository.findAll()
                .get(cardRepository.findAll().size() - 1);

        assertEquals(15L, savedCard.getAccount().getAccountId());
        assertNotNull(savedCard.getCardNumber());
        assertEquals(16, savedCard.getCardNumber().length());
        assertTrue(savedCard.getCardNumber().matches("\\d{16}"));
        assertTrue(savedCard.getCardNumber().startsWith("4"));

        assertEquals("ACTIVE", savedCard.getCardStatus());

        assertNotNull(savedCard.getCreatedAt());
        assertFalse(savedCard.getCreatedAt().isBefore(beforeRequest));
        assertFalse(savedCard.getCreatedAt().isAfter(afterRequest));

        assertEquals(
                savedCard.getCreatedAt().toLocalDate().plusYears(10),
                savedCard.getExpiryDate()
        );
    }

    //Úspěšné zablokování karty
    @Test
    void shouldBlockActiveCardSuccessfully() throws Exception {

        Card cardBefore = cardRepository.findById(1L).orElseThrow();

        Long accountIdBefore = cardBefore.getAccount().getAccountId();
        String cardNumberBefore = cardBefore.getCardNumber();
        LocalDate expiryDateBefore = cardBefore.getExpiryDate();
        LocalDateTime createdAtBefore = cardBefore.getCreatedAt();

        assertEquals("ACTIVE", cardBefore.getCardStatus());

        mockMvc.perform(patch("/cards/1/block")).andExpect(status().isOk());

        Card cardAfter = cardRepository.findById(1L).orElseThrow();

        assertEquals("BLOCKED", cardAfter.getCardStatus());
        assertEquals(accountIdBefore, cardAfter.getAccount().getAccountId());
        assertEquals(cardNumberBefore, cardAfter.getCardNumber());
        assertEquals(expiryDateBefore, cardAfter.getExpiryDate());
        assertEquals(createdAtBefore, cardAfter.getCreatedAt());
    }

    //Negativní testy
    @Test
    void shouldReturn404WhenIssuingCardToNonExistingAccount() throws Exception {

        mockMvc.perform(post("/cards")
                        .contentType(APPLICATION_JSON)
                        .content("""
                        {
                            "accountId": 999999
                        }
                        """))
                .andExpect(status().isNotFound());

        assertEquals(
                12,
                cardRepository.count()
        );
    }

    @Test
    void shouldReturn400WhenAccountIdIsNull() throws Exception {

        mockMvc.perform(post("/cards")
                        .contentType(APPLICATION_JSON)
                        .content("""
                        {
                            "accountId": null
                        }
                        """))
                .andExpect(status().isBadRequest());

        assertEquals(
                12,
                cardRepository.count()
        );
    }

    @Test
    void shouldReturn400WhenAccountIdIsMissing() throws Exception {

        mockMvc.perform(post("/cards")
                        .contentType(APPLICATION_JSON)
                        .content("""
                        {
                        }
                        """))
                .andExpect(status().isBadRequest());

        assertEquals(
                12,
                cardRepository.count()
        );
    }

    @Test
    void shouldReturn404WhenBlockingNonExistingCard() throws Exception {

        mockMvc.perform(patch("/cards/999999/block"))
                .andExpect(status().isNotFound());

        assertEquals(
                12,
                cardRepository.count()
        );
    }

    @Test
    void shouldReturn400WhenBlockingAlreadyBlockedCard() throws Exception {

        Card cardBefore = cardRepository.findById(5L).orElseThrow();

        assertEquals("BLOCKED", cardBefore.getCardStatus());

        mockMvc.perform(patch("/cards/5/block"))
                .andExpect(status().isBadRequest());

        Card cardAfter = cardRepository.findById(5L).orElseThrow();

        assertEquals("BLOCKED", cardAfter.getCardStatus());
    }

    @Test
    void shouldReturn400WhenBlockingExpiredCard() throws Exception {

        Card cardBefore = cardRepository.findById(7L).orElseThrow();

        assertEquals("EXPIRED", cardBefore.getCardStatus());

        mockMvc.perform(patch("/cards/7/block"))
                .andExpect(status().isBadRequest());

        Card cardAfter = cardRepository.findById(7L).orElseThrow();

        assertEquals("EXPIRED", cardAfter.getCardStatus());
    }
}