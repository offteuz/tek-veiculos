package br.com.api.tekveiculos.dto.request;

public record MemberUpdatePasswordRequestDTO(

        String currentPassword,

        String newPassword
) {
}
