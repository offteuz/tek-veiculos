package br.com.api.tekveiculos.exception;

public class VehicleNotFoundException extends RuntimeException{

    public VehicleNotFoundException() {
        super("Veículo não encontrado. Verifique!");
    }

    public VehicleNotFoundException(String message) {
        super(message);
    }
}
