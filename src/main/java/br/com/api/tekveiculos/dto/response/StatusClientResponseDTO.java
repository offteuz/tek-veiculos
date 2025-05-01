package br.com.api.tekveiculos.dto.response;

import br.com.api.tekveiculos.model.Status;

public record StatusClientResponseDTO(

        Long id,

        String description
) {

    public StatusClientResponseDTO(Status status) {
        this(
                status.getId(),
                status.getDescription()
        );
    }
}
