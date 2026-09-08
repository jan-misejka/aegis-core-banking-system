package cz.aegis.corebanking.controller;

import cz.aegis.corebanking.TestDatabaseReset;
import cz.aegis.corebanking.entity.Account;
import cz.aegis.corebanking.entity.Transaction;
import cz.aegis.corebanking.repository.AccountRepository;
import cz.aegis.corebanking.repository.TransactionRepository;
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
public class TransactionControllerTest extends TestDatabaseReset {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    // Deposit testy
    @Test
    void shouldDepositMoneySuccessfully() throws Exception {

        Account accountBefore = accountRepository.findById(1L).orElseThrow();
        BigDecimal initialBalance = accountBefore.getBalance();
        long initialTransactionCount = transactionRepository.count();

        mockMvc.perform(post("/transactions")
                        .contentType(APPLICATION_JSON)
                        .content("""
                                {
                                    "accountId": 1,
                                    "type": "DEPOSIT",
                                    "amount": 500.00
                                }
                                """))
                .andExpect(status().isOk());

        Account accountAfter = accountRepository.findById(1L).orElseThrow();

        assertEquals(
                initialBalance.add(new BigDecimal("500.00")),
                accountAfter.getBalance()
        );

        long finalTransactionCount = transactionRepository.count();

        assertEquals(initialTransactionCount + 1, finalTransactionCount);

        Transaction depositTransaction = transactionRepository.findAll()
                .get(transactionRepository.findAll().size() - 1);

        assertEquals("DEPOSIT", depositTransaction.getTransactionType());
        assertEquals(new BigDecimal("500.00"), depositTransaction.getAmount());
        assertEquals(1L, depositTransaction.getAccount().getAccountId());
        assertNotNull(depositTransaction.getCreatedAt());
    }

    @Test
    void shouldReturn400WhenDepositingZeroAmount() throws Exception {

        mockMvc.perform(post("/transactions")
                        .contentType(APPLICATION_JSON)
                        .content("""
                                {
                                    "accountId": 1,
                                    "type": "DEPOSIT",
                                    "amount": 0
                                }
                                """))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturn400WhenDepositingNegativeAmount() throws Exception {

        mockMvc.perform(post("/transactions")
                        .contentType(APPLICATION_JSON)
                        .content("""
                                {
                                    "accountId": 1,
                                    "type": "DEPOSIT",
                                    "amount": -100
                                }
                                """))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturn404WhenDepositingToNonExistingAccount() throws Exception {

        mockMvc.perform(post("/transactions")
                        .contentType(APPLICATION_JSON)
                        .content("""
                                {
                                    "accountId": 999999,
                                    "type": "DEPOSIT",
                                    "amount": 500.00
                                }
                                """))
                .andExpect(status().isNotFound());
    }

    //Withdraw testy
    @Test
    void shouldWithdrawMoneySuccessfully() throws Exception {

        Account accountBefore = accountRepository.findById(1L).orElseThrow();
        BigDecimal initialBalance = accountBefore.getBalance();
        long initialTransactionCount = transactionRepository.count();

        mockMvc.perform(post("/transactions")
                        .contentType(APPLICATION_JSON)
                        .content("""
                                {
                                    "accountId": 1,
                                    "type": "WITHDRAWAL",
                                    "amount": 500.00
                                }
                                """))
                .andExpect(status().isOk());

        Account accountAfter = accountRepository.findById(1L).orElseThrow();

        assertEquals(
                initialBalance.subtract(new BigDecimal("500.00")),
                accountAfter.getBalance()
        );

        long finalTransactionCount = transactionRepository.count();

        assertEquals(initialTransactionCount + 1, finalTransactionCount);

        Transaction withdrawalTransaction = transactionRepository.findAll()
                .get(transactionRepository.findAll().size() - 1);

        assertEquals("WITHDRAWAL", withdrawalTransaction.getTransactionType());
        assertEquals(new BigDecimal("500.00"), withdrawalTransaction.getAmount());
        assertEquals(1L, withdrawalTransaction.getAccount().getAccountId());
        assertNotNull(withdrawalTransaction.getCreatedAt());
    }

    @Test
    void shouldReturn400WhenWithdrawingZeroAmount() throws Exception {

        mockMvc.perform(post("/transactions")
                        .contentType(APPLICATION_JSON)
                        .content("""
                                {
                                    "accountId": 1,
                                    "type": "WITHDRAWAL",
                                    "amount": 0
                                }
                                """))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturn400WhenWithdrawingNegativeAmount() throws Exception {

        mockMvc.perform(post("/transactions")
                        .contentType(APPLICATION_JSON)
                        .content("""
                                {
                                    "accountId": 1,
                                    "type": "WITHDRAWAL",
                                    "amount": -100
                                }
                                """))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturn404WhenWithdrawingFromNonExistingAccount() throws Exception {

        mockMvc.perform(post("/transactions")
                        .contentType(APPLICATION_JSON)
                        .content("""
                                {
                                    "accountId": 999999,
                                    "type": "WITHDRAWAL",
                                    "amount": 500.00
                                }
                                """))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldReturn400WhenWithdrawingMoreThanBalance() throws Exception {

        Account accountBefore = accountRepository.findById(1L).orElseThrow();
        BigDecimal initialBalance = accountBefore.getBalance();
        long initialTransactionCount = transactionRepository.count();

        mockMvc.perform(post("/transactions")
                        .contentType(APPLICATION_JSON)
                        .content("""
                                {
                                    "accountId": 1,
                                    "type": "WITHDRAWAL",
                                    "amount": 25000.01
                                }
                                """))
                .andExpect(status().isBadRequest());

        Account accountAfter = accountRepository.findById(1L).orElseThrow();

        assertEquals(initialBalance, accountAfter.getBalance());

        long finalTransactionCount = transactionRepository.count();

        assertEquals(initialTransactionCount, finalTransactionCount);
    }

    @Test
    void shouldWithdrawEntireBalanceSuccessfully() throws Exception {

        Account accountBefore = accountRepository.findById(1L).orElseThrow();
        BigDecimal initialBalance = accountBefore.getBalance();

        mockMvc.perform(post("/transactions")
                        .contentType(APPLICATION_JSON)
                        .content("""
                                {
                                    "accountId": 1,
                                    "type": "WITHDRAWAL",
                                    "amount": 25000.00
                                }
                                """))
                .andExpect(status().isOk());

        Account accountAfter = accountRepository.findById(1L).orElseThrow();

        assertEquals(
                initialBalance.subtract(new BigDecimal("25000.00")),
                accountAfter.getBalance()
        );
    }

    //Validační testy na transaction type
    @Test
    void shouldReturn400WhenTransactionTypeIsInvalid() throws Exception {

        Account accountBefore = accountRepository.findById(1L).orElseThrow();
        BigDecimal initialBalance = accountBefore.getBalance();
        long initialTransactionCount = transactionRepository.count();

        mockMvc.perform(post("/transactions")
                        .contentType(APPLICATION_JSON)
                        .content("""
                                {
                                    "accountId": 1,
                                    "type": "INVALID",
                                    "amount": 500.00
                                }
                                """))
                .andExpect(status().isBadRequest());

        Account accountAfter = accountRepository.findById(1L).orElseThrow();

        assertEquals(initialBalance, accountAfter.getBalance());
        assertEquals(initialTransactionCount, transactionRepository.count());
    }

    @Test
    void shouldReturn400WhenTransactionTypeIsMissing() throws Exception {

        mockMvc.perform(post("/transactions")
                        .contentType(APPLICATION_JSON)
                        .content("""
                                {
                                    "accountId": 1,
                                    "amount": 500.00
                                }
                                """))
                .andExpect(status().isBadRequest());
    }
}