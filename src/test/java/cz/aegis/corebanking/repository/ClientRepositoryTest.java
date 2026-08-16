package cz.aegis.corebanking.repository;

import cz.aegis.corebanking.entity.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    void shouldLoadAllClients() {

        List<Client> clients = clientRepository.findAll();

        assertEquals(11, clients.size());
    }
}