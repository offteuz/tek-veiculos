package br.com.api.tekveiculos.service;

import br.com.api.tekveiculos.dto.request.StatusRequestDTO;
import br.com.api.tekveiculos.dto.response.StatusResponseDTO;
import br.com.api.tekveiculos.exception.StatusNotFoundException;
import br.com.api.tekveiculos.mapper.StatusMapper;
import br.com.api.tekveiculos.model.Status;
import br.com.api.tekveiculos.repository.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    private final StatusRepository statusRepository;

    private final StatusMapper statusMapper;

    private StatusService(StatusRepository statusRepository, StatusMapper statusMapper) {
        this.statusRepository = statusRepository;
        this.statusMapper = statusMapper;
    }

    public StatusResponseDTO create(StatusRequestDTO dto) {
        Status status = statusMapper.toDTO(dto);

        return new StatusResponseDTO(statusRepository.save(status));
    }

    public List<StatusResponseDTO> findAll() {
        return statusRepository.findAll()
                .stream()
                .map(StatusResponseDTO::new)
                .toList();
    }

    public StatusResponseDTO findById(Long idStatus) {
        Status status = statusRepository.findById(idStatus)
                .orElseThrow(() -> new StatusNotFoundException());

        return new StatusResponseDTO(status);
    }

    public StatusResponseDTO update(Long idStatus, StatusRequestDTO dto) {
        Status status = statusRepository.findById(idStatus)
                .orElseThrow(() -> new StatusNotFoundException());

        statusMapper.update(dto, status);

        return new StatusResponseDTO(statusRepository.save(status));
    }

    public void delete(Long idStatus) {
        Status status = statusRepository.findById(idStatus)
                .orElseThrow(() -> new StatusNotFoundException());

        statusRepository.delete(status);
    }
}
