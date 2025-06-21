package br.com.api.tekveiculos.exception;

public class MemberEmailNotFoundException extends RuntimeException{

    public MemberEmailNotFoundException(String message) {
        super(message);
    }

    public MemberEmailNotFoundException() {
        super("E-mail do usuário não encontrado. Verifique!");
    }
}
