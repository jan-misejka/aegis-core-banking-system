package cz.aegis.corebanking.controller;

import cz.aegis.corebanking.dto.ClientResponse;
import cz.aegis.corebanking.dto.CreateClientRequest;
import cz.aegis.corebanking.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientResponse> createClient(@RequestBody CreateClientRequest request) {

        ClientResponse response = clientService.createClient(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ClientResponse>> getAllClients() {

        List<ClientResponse> clients = clientService.getAllClients();

        return ResponseEntity.ok(clients);
    }
}
