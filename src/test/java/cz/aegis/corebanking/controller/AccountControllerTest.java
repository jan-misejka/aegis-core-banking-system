package cz.aegis.corebanking.controller;

import cz.aegis.corebanking.TestDatabaseReset;
import cz.aegis.corebanking.entity.Account;
import cz.aegis.corebanking.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
public class AccountControllerTest extends TestDatabaseReset {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AccountRepository accountRepository;

    //Testy pro vytvoření účtu
    @Test
    void shouldCreateAccountSuccessfully() throws Exception {

        long initialAccountCount = accountRepository.count();

        mockMvc.perform(post("/accounts")
                        .contentType(APPLICATION_JSON)
                        .content("""
                                {
                                    "clientId": 1,
                                    "accountType": "CURRENT",
                                    "currency": "CZK"
                                }
                                """))
                .andExpect(status().isCreated());

        long finalAccountCount = accountRepository.count();

        assertEquals(initialAccountCount + 1, finalAccountCount);

        Account createdAccount = accountRepository.findAll()
                .get(accountRepository.findAll().size() - 1);

        assertEquals(1L, createdAccount.getClient().getClientId());
        assertEquals("CURRENT", createdAccount.getAccountType());
        assertEquals("CZK", createdAccount.getCurrency());
        assertEquals(BigDecimal.ZERO, createdAccount.getBalance());
        assertNotNull(createdAccount.getIban());
        assertNotNull(createdAccount.getCreatedAt());
    }

    @Test
    void shouldReturn404WhenCreatingAccountForNonExistingClient() throws Exception {

        long initialAccountCount = accountRepository.count();

        mockMvc.perform(post("/accounts")
                        .contentType(APPLICATION_JSON)
                        .content("""
                                {
                                    "clientId": 999999,
                                    "accountType": "CURRENT",
                                    "currency": "CZK"
                                }
                                """))
                .andExpect(status().isNotFound());

        long finalAccountCount = accountRepository.count();

        assertEquals(initialAccountCount, finalAccountCount);
    }

    @Test
    void shouldReturn400WhenCreatingAccountWithInvalidAccountType() throws Exception {

        long initialAccountCount = accountRepository.count();

        mockMvc.perform(post("/accounts")
                        .contentType(APPLICATION_JSON)
                        .content("""
                                {
                                    "clientId": 1,
                                    "accountType": "INVALID",
                                    "currency": "CZK"
                                }
                                """))
                .andExpect(status().isBadRequest());

        long finalAccountCount = accountRepository.count();

        assertEquals(initialAccountCount, finalAccountCount);
    }

    @Test
    void shouldCreateAccountWithSupportedCurrency() throws Exception {

        long initialAccountCount = accountRepository.count();

        mockMvc.perform(post("/accounts")
                        .contentType(APPLICATION_JSON)
                        .content("""
                                {
                                    "clientId": 1,
                                    "accountType": "CURRENT",
                                    "currency": "EUR"
                                }
                                """))
                .andExpect(status().isCreated());

        long finalAccountCount = accountRepository.count();

        assertEquals(initialAccountCount + 1, finalAccountCount);

        Account createdAccount = accountRepository.findAll()
                .get(accountRepository.findAll().size() - 1);

        assertEquals("EUR", createdAccount.getCurrency());
    }

    @Test
    void shouldCreateAccountWithInitialBalanceZero() throws Exception {

        mockMvc.perform(post("/accounts")
                        .contentType(APPLICATION_JSON)
                        .content("""
                                {
                                    "clientId": 1,
                                    "accountType": "SAVINGS",
                                    "currency": "CZK"
                                }
                                """))
                .andExpect(status().isCreated());

        Account createdAccount = accountRepository.findAll()
                .get(accountRepository.findAll().size() - 1);

        assertEquals(BigDecimal.ZERO, createdAccount.getBalance());
    }

    //TC-009-01: Úspěšně zobrazení detailu účtu
    @Test
    void shouldReturnAccountSuccessfully() throws Exception {
        mockMvc.perform(get("/accounts/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.accountId").value(1))
                .andExpect(jsonPath("$.clientId").value(1))
                .andExpect(jsonPath("$.iban").exists())
                .andExpect(jsonPath("$.accountType").value("CURRENT"))
                .andExpect(jsonPath("$.balance").value(25000))
                .andExpect(jsonPath("$.currency").value("CZK"))
                .andExpect(jsonPath("$.createdAt").exists());
    }

    //TC-009-02: Neexistující účet při zobrazení detailu účtu
    @Test
    void shouldReturnA404WHenAccountDoesNotExist() throws Exception {
        mockMvc.perform(get("/accounts/999999")).andExpect(status().isNotFound());
    }

    // TC-009-03 – Zobrazení účtu s nulovým zůstatkem
    @Test
    void shouldReturnAccountWithZeroBalance() throws Exception {
        mockMvc.perform(get("/accounts/7"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.balance").value(0));
    }

    // TC-009-04 – GET detailu účtu nemění stav databáze
    @Test
    void shouldNotModifyAccountWhenGettingAccount() throws Exception {
        Account accountBefore = accountRepository.findById(1L).orElseThrow();

        mockMvc.perform(get("/accounts/1"))
                .andExpect(status().isOk());

        Account accountAfter = accountRepository.findById(1L).orElseThrow();

        assertEquals(accountBefore.getAccountId(), accountAfter.getAccountId());
        assertEquals(accountBefore.getClient().getClientId(), accountAfter.getClient().getClientId());
        assertEquals(accountBefore.getIban(), accountAfter.getIban());
        assertEquals(accountBefore.getAccountType(), accountAfter.getAccountType());
        assertEquals(accountBefore.getBalance(), accountAfter.getBalance());
        assertEquals(accountBefore.getCurrency(), accountAfter.getCurrency());
        assertEquals(accountBefore.getCreatedAt(), accountAfter.getCreatedAt());
    }
}