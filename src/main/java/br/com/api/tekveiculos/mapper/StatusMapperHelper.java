package br.com.api.tekveiculos.mapper;

import br.com.api.tekveiculos.exception.StatusNotFoundException;
import br.com.api.tekveiculos.model.Status;
import br.com.api.tekveiculos.repository.StatusRepository;
import org.springframework.stereotype.Component;

@Component
public class StatusMapperHelper {

    private final StatusRepository statusRepository;

    public StatusMapperHelper(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public Status map(Long idStatus) {
        return statusRepository.findById(idStatus)
                .orElseThrow(() -> new StatusNotFoundException());
    }
}
