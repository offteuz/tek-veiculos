package br.com.api.tekveiculos.dto.response;

import br.com.api.tekveiculos.model.Audit;
import br.com.api.tekveiculos.model.Member;
import br.com.api.tekveiculos.model.Status;
import br.com.api.tekveiculos.model.enumerator.RoleMember;

public record MemberResponseDTO(

        Long id,

        RoleMember roleMember,

        String email,

        String name,

        StatusSummaryResponseDTO status,

        Audit audit
) {

    public MemberResponseDTO(Member member) {
        this(
                member.getId(),
                member.getRoleMember(),
                member.getEmail(),
                member.getName(),
                new StatusSummaryResponseDTO(member.getStatus()),
                member.getAudit()
        );
    }
}
