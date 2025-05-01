package br.com.api.tekveiculos.dto.response;

import br.com.api.tekveiculos.model.Audit;
import br.com.api.tekveiculos.model.Client;
import br.com.api.tekveiculos.model.Status;

import java.util.List;

public record StatusResponseDTO(

        Long id,

        String description,

        Audit audit,

        List<Client> clientList
) {

    public StatusResponseDTO(Status status) {
        this(
                status.getId(),
                status.getDescription(),
                status.getAudit(),
                status.getClientList()
        );
    }
}
