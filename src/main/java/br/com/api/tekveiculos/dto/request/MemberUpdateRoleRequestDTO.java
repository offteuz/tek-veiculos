package br.com.api.tekveiculos.dto.request;

import br.com.api.tekveiculos.model.enumerator.RoleMember;

public record MemberUpdateRoleRequestDTO(

        RoleMember roleMember
) {
}
