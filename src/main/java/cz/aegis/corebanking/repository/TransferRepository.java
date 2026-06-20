package cz.aegis.corebanking.repository;

import cz.aegis.corebanking.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer, Long> {
}