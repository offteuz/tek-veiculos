package br.com.api.tekveiculos.exception;

public class VisitClientNotFoundException extends RuntimeException{

    public VisitClientNotFoundException() {
        super("Registro de visita ao cliente não encontrado. Verifique!");
    }

    public VisitClientNotFoundException(String message) {
        super();
    }
}
