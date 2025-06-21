package br.com.api.tekveiculos.exception;

import com.auth0.jwt.exceptions.JWTCreationException;

public class GenerateTokenErrorException extends RuntimeException {

    public GenerateTokenErrorException() {
        super("Ocorreu um erro ao GERAR o token. Verifique!");
    }

    public GenerateTokenErrorException(String message) {
        super(message);
    }
}
