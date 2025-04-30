package br.com.api.tekveiculos.service;

import br.com.api.tekveiculos.dto.request.StatusRequestDTO;
import br.com.api.tekveiculos.dto.response.StatusResponseDTO;
import br.com.api.tekveiculos.mapper.StatusMapper;
import br.com.api.tekveiculos.model.Status;
import br.com.api.tekveiculos.repository.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    private final StatusRepository repository;

    private final StatusMapper mapper;

    private StatusService(StatusRepository repository, StatusMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public StatusResponseDTO create(StatusRequestDTO dto) {
        Status status = mapper.toDTO(dto);

        return new StatusResponseDTO(repository.save(status));
    }

    public List<StatusResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(StatusResponseDTO::new)
                .toList();
    }

    public StatusResponseDTO findById(Long id) {
        Status status = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Status não encontrado. Verifique!"));

        return new StatusResponseDTO(status);
    }

    public StatusResponseDTO update(Long id, StatusRequestDTO dto) {
        Status status = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Status não encontrado. Verifique!"));

        mapper.update(dto, status);

        return new StatusResponseDTO(repository.save(status));
    }

    public void delete(Long id) {
        Status status = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Status não encontrado. Verifique!"));

        repository.delete(status);
    }
}
