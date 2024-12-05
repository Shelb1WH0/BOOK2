package com.demo.service;

import com.demo.model.Client;
import com.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }


    public Client getClientById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.orElseThrow(() -> new RuntimeException("Client not found"));
    }
    public Client updateClient(Long id, Client updatedClient) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        client.setFullName(updatedClient.getFullName());
        client.setAge(updatedClient.getAge());
        return clientRepository.save(client);
    }
    public void deleteClient(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new RuntimeException("Client not found");
        }
        clientRepository.deleteById(id);
    }
}
