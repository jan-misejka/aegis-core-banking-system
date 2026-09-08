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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
}