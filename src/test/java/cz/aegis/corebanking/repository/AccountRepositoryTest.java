package cz.aegis.corebanking.repository;

import cz.aegis.corebanking.entity.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    void shouldLoadAccountWithClient() {

        Optional<Account> accountOptional =
                accountRepository.findById(1L);

        assertTrue(accountOptional.isPresent());

        Account account = accountOptional.get();

        assertNotNull(account.getClient());

        assertEquals("Honza",
                account.getClient().getFirstName());
    }
}