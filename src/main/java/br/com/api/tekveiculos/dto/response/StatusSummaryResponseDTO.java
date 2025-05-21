package br.com.api.tekveiculos.dto.response;

import br.com.api.tekveiculos.model.Status;

public record StatusSummaryResponseDTO(

        Long id,

        String description
) {

    public StatusSummaryResponseDTO(Status status) {
        this(
                status.getId(),
                status.getDescription()
        );
    }
}
