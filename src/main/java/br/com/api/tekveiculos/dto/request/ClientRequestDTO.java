package br.com.api.tekveiculos.dto.request;

import org.hibernate.validator.constraints.br.CNPJ;

public record ClientRequestDTO(

        String socialReason,

        String fantasyName,

        @CNPJ
        String cnpj,

        String city,

        String uf,

        Long statusId
) {
}
