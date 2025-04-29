package br.com.api.tekveiculos.dto.response;

import br.com.api.tekveiculos.model.Audit;
import br.com.api.tekveiculos.model.Status;

public record StatusResponseDTO(

        Long id,

        String description,

        Audit audit
) {

    public StatusResponseDTO(Status status) {
        this(
                status.getId(),
                status.getDescription(),
                status.getAudit()
        );
    }
}
