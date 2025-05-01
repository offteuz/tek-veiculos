package br.com.api.tekveiculos.dto.request;

public record ClientRequestDTO(

        String socialReason,

        String fantasyName,

        String city,

        String uf,

        Long statusId
) {
}
