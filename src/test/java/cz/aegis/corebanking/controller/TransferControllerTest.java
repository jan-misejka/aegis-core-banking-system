package cz.aegis.corebanking.controller;

import cz.aegis.corebanking.TestDatabaseReset;
import cz.aegis.corebanking.entity.Account;
import cz.aegis.corebanking.entity.Transaction;
import cz.aegis.corebanking.entity.Transfer;
import cz.aegis.corebanking.repository.AccountRepository;
import cz.aegis.corebanking.repository.TransactionRepository;
import cz.aegis.corebanking.repository.TransferRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
public class TransferControllerTest extends TestDatabaseReset {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransferRepository transferRepository;

    // Successful transfer tests
    @Test
    void shouldTransferMoneySuccessfully() throws Exception {

        Account sourceBefore = accountRepository.findById(1L).orElseThrow();
        Account targetBefore = accountRepository.findById(3L).orElseThrow();

        BigDecimal sourceInitialBalance = sourceBefore.getBalance();
        BigDecimal targetInitialBalance = targetBefore.getBalance();

        long initialTransferCount = transferRepository.count();
        long initialTransactionCount = transactionRepository.count();

        mockMvc.perform(post("/transfers")
                        .contentType(APPLICATION_JSON)
                        .content("""
                        {
                            "sourceAccountId": 1,
                            "targetAccountId": 3,
                            "amount": 1000.00
                        }
                        """))
                .andExpect(status().isCreated());

        Account sourceAfter = accountRepository.findById(1L).orElseThrow();
        Account targetAfter = accountRepository.findById(3L).orElseThrow();

        assertEquals(
                sourceInitialBalance.subtract(new BigDecimal("1000.00")),
                sourceAfter.getBalance()
        );

        assertEquals(
                targetInitialBalance.add(new BigDecimal("1000.00")),
                targetAfter.getBalance()
        );

        assertEquals(initialTransferCount + 1, transferRepository.count());
        assertEquals(initialTransactionCount + 2, transactionRepository.count());

        Transfer transfer = transferRepository.findAll()
                .get(transferRepository.findAll().size() - 1);

        assertEquals(1L, transfer.getSourceAccount().getAccountId());
        assertEquals(3L, transfer.getTargetAccount().getAccountId());
        assertEquals(new BigDecimal("1000.00"), transfer.getAmount());
        assertEquals("COMPLETED", transfer.getTransferStatus());

        List<Transaction> transactions = transactionRepository.findAll();

        Transaction outboundTransaction = transactions.stream()
                .filter(transaction ->
                        "OUTBOUND".equals(transaction.getTransactionType())
                                && transaction.getTransfer() != null
                                && transaction.getTransfer().getTransferId()
                                .equals(transfer.getTransferId()))
                .findFirst()
                .orElseThrow();

        Transaction inboundTransaction = transactions.stream()
                .filter(transaction ->
                        "INBOUND".equals(transaction.getTransactionType())
                                && transaction.getTransfer() != null
                                && transaction.getTransfer().getTransferId()
                                .equals(transfer.getTransferId()))
                .findFirst()
                .orElseThrow();

        assertEquals(1L, outboundTransaction.getAccount().getAccountId());
        assertEquals(3L, inboundTransaction.getAccount().getAccountId());

        assertEquals(new BigDecimal("1000.00"), outboundTransaction.getAmount());
        assertEquals(new BigDecimal("1000.00"), inboundTransaction.getAmount());

        assertEquals(
                transfer.getTransferId(),
                outboundTransaction.getTransfer().getTransferId()
        );

        assertEquals(
                transfer.getTransferId(),
                inboundTransaction.getTransfer().getTransferId()
        );
    }

    // Negative transfer tests
    @Test
    void shouldReturn400WhenTransferringZeroAmount() throws Exception {

        mockMvc.perform(post("/transfers")
                        .contentType(APPLICATION_JSON)
                        .content("""
                        {
                            "sourceAccountId": 1,
                            "targetAccountId": 3,
                            "amount": 0
                        }
                        """))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturn400WhenTransferringNegativeAmount() throws Exception {

        mockMvc.perform(post("/transfers")
                        .contentType(APPLICATION_JSON)
                        .content("""
                        {
                            "sourceAccountId": 1,
                            "targetAccountId": 3,
                            "amount": -100
                        }
                        """))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturn404WhenSourceAccountDoesNotExist() throws Exception {

        mockMvc.perform(post("/transfers")
                        .contentType(APPLICATION_JSON)
                        .content("""
                        {
                            "sourceAccountId": 999999,
                            "targetAccountId": 3,
                            "amount": 500.00
                        }
                        """))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldReturn404WhenTargetAccountDoesNotExist() throws Exception {

        mockMvc.perform(post("/transfers")
                        .contentType(APPLICATION_JSON)
                        .content("""
                        {
                            "sourceAccountId": 1,
                            "targetAccountId": 999999,
                            "amount": 500.00
                        }
                        """))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldReturn400WhenTransferringToSameAccount() throws Exception {

        mockMvc.perform(post("/transfers")
                        .contentType(APPLICATION_JSON)
                        .content("""
                        {
                            "sourceAccountId": 1,
                            "targetAccountId": 1,
                            "amount": 500.00
                        }
                        """))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturn400WhenTransferringMoreThanBalance() throws Exception {

        Account sourceBefore = accountRepository.findById(1L).orElseThrow();
        BigDecimal initialBalance = sourceBefore.getBalance();

        long initialTransferCount = transferRepository.count();
        long initialTransactionCount = transactionRepository.count();

        mockMvc.perform(post("/transfers")
                        .contentType(APPLICATION_JSON)
                        .content("""
                        {
                            "sourceAccountId": 1,
                            "targetAccountId": 3,
                            "amount": 25000.01
                        }
                        """))
                .andExpect(status().isBadRequest());

        Account sourceAfter = accountRepository.findById(1L).orElseThrow();

        assertEquals(initialBalance, sourceAfter.getBalance());
        assertEquals(initialTransferCount, transferRepository.count());
        assertEquals(initialTransactionCount, transactionRepository.count());
    }

    @Test
    void shouldReturn400WhenSourceAccountIdIsNull() throws Exception {

        mockMvc.perform(post("/transfers")
                        .contentType(APPLICATION_JSON)
                        .content("""
                    {
                        "sourceAccountId": null,
                        "targetAccountId": 3,
                        "amount": 500.00
                    }
                    """))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturn400WhenTargetAccountIdIsNull() throws Exception {

        mockMvc.perform(post("/transfers")
                        .contentType(APPLICATION_JSON)
                        .content("""
                    {
                        "sourceAccountId": 1,
                        "targetAccountId": null,
                        "amount": 500.00
                    }
                    """))
                .andExpect(status().isBadRequest());
    }
}