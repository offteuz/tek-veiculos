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

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/create/client")
    @ResponseStatus(HttpStatus.CREATED)
    private ClientResponseDTO create(@Valid @RequestBody ClientRequestDTO dto) {
        return clientService.create(dto);
    }

    @GetMapping("/find-all/client")
    @ResponseStatus(HttpStatus.OK)
    private List<ClientResponseDTO> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/find-by-id/client/{idClient}")
    @ResponseStatus(HttpStatus.OK)
    private ClientResponseDTO findById(@PathVariable Long idClient) {
        return clientService.findById(idClient);
    }

    @PutMapping("/update/client/{idClient}")
    @ResponseStatus(HttpStatus.OK)
    private ClientResponseDTO update(@PathVariable Long idClient, @Valid @RequestBody ClientRequestDTO dto) {
        return clientService.update(idClient, dto);
    }

    @DeleteMapping("/delete/client/{idClient}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void delete(@PathVariable Long idClient) {
        clientService.delete(idClient);
    }
}
