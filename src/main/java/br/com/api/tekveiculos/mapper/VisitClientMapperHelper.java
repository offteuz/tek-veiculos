package br.com.api.tekveiculos.mapper;

import br.com.api.tekveiculos.exception.VisitClientNotFoundException;
import br.com.api.tekveiculos.model.VisitClient;
import br.com.api.tekveiculos.repository.VisitClientRepository;
import org.springframework.stereotype.Component;

@Component
public class VisitClientMapperHelper {

    private final VisitClientRepository visitClientRepository;

    public VisitClientMapperHelper(VisitClientRepository visitClientRepository) {
        this.visitClientRepository = visitClientRepository;
    }

    public VisitClient map(Long idVisitClient) {
        return visitClientRepository.findById(idVisitClient)
                .orElseThrow(VisitClientNotFoundException::new);
    }
}
