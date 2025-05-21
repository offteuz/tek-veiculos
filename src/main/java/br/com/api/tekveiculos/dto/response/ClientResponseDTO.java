package br.com.api.tekveiculos.dto.response;

import br.com.api.tekveiculos.model.Audit;
import br.com.api.tekveiculos.model.Client;

public record ClientResponseDTO(

        Long id,

        String socialReason,

        String fantasyName,

        String cnpj,

        String city,

        String uf,

        StatusSummaryResponseDTO status,

        Audit audit
) {

    public ClientResponseDTO(Client client) {
        this(
                client.getId(),
                client.getSocialReason(),
                client.getFantasyName(),
                client.getCnpj(),
                client.getCity(),
                client.getUf(),
                new StatusSummaryResponseDTO(client.getStatus()),
                client.getAudit()
        );
    }
}
