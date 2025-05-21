package br.com.api.tekveiculos.handler;

import br.com.api.tekveiculos.config.ApiError;
import br.com.api.tekveiculos.exception.ClientNotFoundException;
import br.com.api.tekveiculos.exception.StatusNotFoundException;
import br.com.api.tekveiculos.exception.VehicleNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler({ClientNotFoundException.class, StatusNotFoundException.class, VehicleNotFoundException.class})
    public ResponseEntity<ApiError> notFoundException(RuntimeException e) {
        ApiError apiError = ApiError
                .builder()
                .timestamp(LocalDateTime.now())
                .code(HttpStatus.NOT_FOUND.value())
                .status(HttpStatus.NOT_FOUND.name())
                .errors(List.of(e.getMessage()))
                .build();

        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }
}
