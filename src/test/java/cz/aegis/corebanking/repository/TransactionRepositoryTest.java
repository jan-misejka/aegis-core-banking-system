package cz.aegis.corebanking.repository;

import cz.aegis.corebanking.TestDatabaseReset;
import cz.aegis.corebanking.entity.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class TransactionRepositoryTest extends TestDatabaseReset {

    @Autowired
    private TransactionRepository transactionRepository;

    @Test
    void shouldLoadAllTransactions() {

        List<Transaction> transactions =
                transactionRepository.findAll();

        assertEquals(50, transactions.size());
    }

    @Test
    void shouldLoadTransactionWithRelations() {

        Transaction transaction =
                transactionRepository.findById(1L)
                        .orElseThrow();

        assertNotNull(transaction.getAccount());

        assertNotNull(transaction.getTransfer());
    }
}