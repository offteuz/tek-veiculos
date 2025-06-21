package br.com.api.tekveiculos.exception;

public class MemberNotFoundException extends RuntimeException{

    public MemberNotFoundException() {
        super("Usuário não encontrado. Verifique!");
    }

    public MemberNotFoundException(String message) {
        super(message);
    }
}
