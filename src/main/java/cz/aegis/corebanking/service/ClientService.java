package cz.aegis.corebanking.service;

import cz.aegis.corebanking.dto.UpdateClientRequest;
import cz.aegis.corebanking.repository.ClientRepository;
import org.springframework.stereotype.Service;

import cz.aegis.corebanking.dto.ClientResponse;
import cz.aegis.corebanking.dto.CreateClientRequest;
import cz.aegis.corebanking.entity.Client;

import java.util.List;

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

    public List<ClientResponse> getAllClients() {
        List<Client> clients = clientRepository.findAll();

        return clients.stream()
                .map(client -> {
                    ClientResponse response = new ClientResponse();

                    response.setClientId(client.getClientId());
                    response.setFirstName(client.getFirstName());
                    response.setLastName(client.getLastName());
                    response.setEmail(client.getEmail());
                    response.setPhoneNumber(client.getPhoneNumber());
                    response.setCreatedAt(client.getCreatedAt());

                    return response;
                })
                .toList();
    }

    public ClientResponse getClientById(Long id) {
        Client client = clientRepository.findById(id).orElse(null);

        if (client == null) {
            return null;
        }

        ClientResponse response = new ClientResponse();

        response.setClientId(client.getClientId());
        response.setFirstName(client.getFirstName());
        response.setLastName(client.getLastName());
        response.setEmail(client.getEmail());
        response.setPhoneNumber(client.getPhoneNumber());
        response.setCreatedAt(client.getCreatedAt());

        return response;
    }

    public ClientResponse updateClient(Long id, UpdateClientRequest request) {
        Client client = clientRepository.findById(id).orElse(null);

        if (client == null) {
            return null;
        }

        client.setFirstName(request.getFirstName());
        client.setLastName(request.getLastName());
        client.setEmail(request.getEmail());
        client.setPhoneNumber(request.getPhoneNumber());

        Client updatedClient = clientRepository.save(client);

        ClientResponse response = new ClientResponse();

        response.setClientId(updatedClient.getClientId());
        response.setFirstName(updatedClient.getFirstName());
        response.setLastName(updatedClient.getLastName());
        response.setEmail(updatedClient.getEmail());
        response.setPhoneNumber(updatedClient.getPhoneNumber());
        response.setCreatedAt(updatedClient.getCreatedAt());

        return response;
    }

    public boolean deleteClient(Long id) {
        Client client = clientRepository.findById(id).orElse(null);

        if (client == null) {
            return false;
        }

        clientRepository.delete(client);

        return true;
    }
}