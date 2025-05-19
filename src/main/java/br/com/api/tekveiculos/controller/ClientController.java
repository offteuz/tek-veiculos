package br.com.api.tekveiculos.controller;

import br.com.api.tekveiculos.dto.request.ClientRequestDTO;
import br.com.api.tekveiculos.dto.response.ClientResponseDTO;
import br.com.api.tekveiculos.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/find-all/client")
    @ResponseStatus(HttpStatus.OK)
    private List<ClientResponseDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/find-by-id/client/{idClient}")
    @ResponseStatus(HttpStatus.OK)
    private ClientResponseDTO findById(@PathVariable Long idClient) {
        return service.findById(idClient);
    }

    @PutMapping("/update/client/{idClient}")
    @ResponseStatus(HttpStatus.OK)
    private ClientResponseDTO update(@PathVariable Long idClient, @Valid @RequestBody ClientRequestDTO dto) {
        return service.update(idClient, dto);
    }

    @DeleteMapping("/delete/client/{idClient}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void delete(@PathVariable Long idClient) {
        service.delete(idClient);
    }
}
