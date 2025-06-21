package br.com.api.tekveiculos.mapper;

import br.com.api.tekveiculos.exception.ClientNotFoundException;
import br.com.api.tekveiculos.model.Client;
import br.com.api.tekveiculos.repository.ClientRepository;
import org.springframework.stereotype.Component;

@Component
public class ClientMapperHelper {

    private final ClientRepository clientRepository;

    public ClientMapperHelper(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client map(Long idClient) {
        return clientRepository.findById(idClient)
                .orElseThrow(ClientNotFoundException::new);
    }
}
