package cz.aegis.corebanking.repository;

import cz.aegis.corebanking.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    boolean existsByIban(String iban);
}