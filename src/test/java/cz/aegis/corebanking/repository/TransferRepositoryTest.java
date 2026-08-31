package cz.aegis.corebanking.repository;

import cz.aegis.corebanking.TestDatabaseReset;
import cz.aegis.corebanking.entity.Transfer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class TransferRepositoryTest extends TestDatabaseReset {

    @Autowired
    private TransferRepository transferRepository;

    @Test
    void shouldLoadAllTransfers() {

        List<Transfer> transfers = transferRepository.findAll();

        assertEquals(20, transfers.size());
    }
//test relace
    @Test
    void shouldLoadTransferWithAccounts() {

        Transfer transfer =
                transferRepository.findById(1L)
                        .orElseThrow();

        assertNotNull(transfer.getSourceAccount());

        assertNotNull(transfer.getTargetAccount());

        assertNotEquals(
                transfer.getSourceAccount().getAccountId(),
                transfer.getTargetAccount().getAccountId()
        );
    }
}