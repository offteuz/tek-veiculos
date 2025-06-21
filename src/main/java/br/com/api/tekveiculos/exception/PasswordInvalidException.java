package br.com.api.tekveiculos.exception;

public class PasswordInvalidException extends RuntimeException{

    public PasswordInvalidException() {
        super("Senha inválida. Verifique!");
    }

    public PasswordInvalidException(String message) {
        super(message);
    }
}
