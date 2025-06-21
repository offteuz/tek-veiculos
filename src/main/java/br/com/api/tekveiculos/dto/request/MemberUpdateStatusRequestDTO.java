package br.com.api.tekveiculos.dto.request;

import br.com.api.tekveiculos.model.Status;

public record MemberUpdateStatusRequestDTO(

        Status status
) {
}
