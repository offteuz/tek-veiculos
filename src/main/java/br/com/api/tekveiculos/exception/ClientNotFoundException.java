package br.com.api.tekveiculos.exception;

public class ClientNotFoundException extends RuntimeException{

    public ClientNotFoundException() {
        super("Cliente não encontrado. Verifique!");
    }

    public ClientNotFoundException(String message) {
        super(message);
    }
}
