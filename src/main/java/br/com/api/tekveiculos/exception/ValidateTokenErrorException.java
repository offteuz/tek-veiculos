package br.com.api.tekveiculos.exception;

public class ValidateTokenErrorException extends RuntimeException{

    public ValidateTokenErrorException() {
        super("Ocorreu um erro ao VALIDAR o token. Verifique!");
    }

    public ValidateTokenErrorException(String message) {
        super(message);
    }
}
