package br.com.api.tekveiculos.service;

import br.com.api.tekveiculos.dto.request.ClientRequestDTO;
import br.com.api.tekveiculos.dto.response.ClientResponseDTO;
import br.com.api.tekveiculos.exception.ClientNotFoundException;
import br.com.api.tekveiculos.mapper.ClientMapper;
import br.com.api.tekveiculos.model.Client;
import br.com.api.tekveiculos.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    private final ClientMapper mapper;


    public ClientService(ClientRepository clientRepository, ClientMapper mapper) {
        this.clientRepository = clientRepository;
        this.mapper = mapper;
    }

    public ClientResponseDTO create(ClientRequestDTO dto) {
        Client client = mapper.toDTO(dto);

        return new ClientResponseDTO(clientRepository.save(client));
    }

    public List<ClientResponseDTO> findAll() {
        return clientRepository.findAll()
                .stream()
                .map(ClientResponseDTO::new)
                .toList();
    }

    public ClientResponseDTO findById(Long idClient) {
        Client client = clientRepository.findById(idClient)
                .orElseThrow(ClientNotFoundException::new);

        return new ClientResponseDTO(client);
    }

    public ClientResponseDTO update(Long idClient, ClientRequestDTO dto) {
        Client client = clientRepository.findById(idClient)
                .orElseThrow(ClientNotFoundException::new);

        mapper.update(dto, client);

        return new ClientResponseDTO(clientRepository.save(client));
    }

    public void delete(Long idClient) {
        Client client = clientRepository.findById(idClient)
                .orElseThrow(ClientNotFoundException::new);

        clientRepository.delete(client);
    }
}
