package br.com.api.tekveiculos.exception;

public class StatusNotFoundException extends RuntimeException {

    public StatusNotFoundException() {
        super("Status não encontrado. Verifique!");
    }

    public StatusNotFoundException(String message) {
        super(message);
    }
}
