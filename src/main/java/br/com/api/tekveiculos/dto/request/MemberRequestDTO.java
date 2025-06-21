package br.com.api.tekveiculos.dto.request;

import br.com.api.tekveiculos.model.enumerator.RoleMember;
import jakarta.validation.constraints.Email;

public record MemberRequestDTO(

        RoleMember roleMember,

        @Email
        String email,

        String name,

        String password,

        Long statusId
) {
}
