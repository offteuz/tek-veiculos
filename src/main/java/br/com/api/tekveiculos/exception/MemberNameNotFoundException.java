package br.com.api.tekveiculos.exception;

public class MemberNameNotFoundException extends RuntimeException{

    public MemberNameNotFoundException(String message) {
        super(message);
    }

    public MemberNameNotFoundException() {
        super("Nome do usuário não encontrado. Verifique!");
    }
}
