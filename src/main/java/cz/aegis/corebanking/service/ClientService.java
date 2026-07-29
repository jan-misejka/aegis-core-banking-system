package cz.aegis.corebanking.service;

import cz.aegis.corebanking.repository.ClientRepository;
import org.springframework.stereotype.Service;

import cz.aegis.corebanking.dto.ClientResponse;
import cz.aegis.corebanking.dto.CreateClientRequest;
import cz.aegis.corebanking.entity.Client;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientResponse createClient(CreateClientRequest request) {
        Client client = new Client();

        client.setFirstName(request.getFirstName());
        client.setLastName(request.getLastName());
        client.setEmail(request.getEmail());
        client.setPhoneNumber(request.getPhoneNumber());

        Client savedClient = clientRepository.save(client);

        ClientResponse response = new ClientResponse();

        response.setClientId(savedClient.getClientId());
        response.setFirstName(savedClient.getFirstName());
        response.setLastName(savedClient.getLastName());
        response.setEmail(savedClient.getEmail());
        response.setPhoneNumber(savedClient.getPhoneNumber());
        response.setCreatedAt(savedClient.getCreatedAt());

        return response;
    }
}