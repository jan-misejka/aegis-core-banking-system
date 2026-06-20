package cz.aegis.corebanking.repository;

import cz.aegis.corebanking.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}