package br.com.api.tekveiculos.exception;

public class SupplyNotFoundException extends RuntimeException{

    public SupplyNotFoundException() {
        super("Abastecimento não encontrado. Verifique!");
    }

    public SupplyNotFoundException(String message) {
        super(message);
    }
}
