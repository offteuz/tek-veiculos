package br.com.api.tekveiculos.dto.request;

import jakarta.validation.constraints.NotNull;

public record StatusRequestDTO(

        @NotNull
        String description
) {
}
