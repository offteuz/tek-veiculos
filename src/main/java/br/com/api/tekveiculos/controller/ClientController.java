package br.com.api.tekveiculos.controller;

import br.com.api.tekveiculos.dto.request.ClientRequestDTO;
import br.com.api.tekveiculos.dto.response.ClientResponseDTO;
import br.com.api.tekveiculos.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @PostMapping("/create/client")
    @ResponseStatus(HttpStatus.CREATED)
    private ClientResponseDTO create(@Valid @RequestBody ClientRequestDTO dto) {
        return service.create(dto);
    }
}
