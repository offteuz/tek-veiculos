package br.com.api.tekveiculos.controller;

import br.com.api.tekveiculos.dto.request.StatusRequestDTO;
import br.com.api.tekveiculos.dto.response.StatusResponseDTO;
import br.com.api.tekveiculos.service.StatusService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StatusController {

    StatusService service;

    private StatusController(StatusService service) {
        this.service = service;
    }

    @PostMapping("/create/status")
    @ResponseStatus(HttpStatus.CREATED)
    private StatusResponseDTO create(@Valid @RequestBody StatusRequestDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/find-all/status")
    @ResponseStatus(HttpStatus.OK)
    private List<StatusResponseDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/find-by-id/status/{idStatus}")
    @ResponseStatus(HttpStatus.OK)
    private StatusResponseDTO findById(@PathVariable Long idStatus) {
        return service.findById(idStatus);
    }

    @PutMapping("/update/status/{idStatus}")
    @ResponseStatus(HttpStatus.OK)
    private StatusResponseDTO update(@PathVariable Long idStatus, @Valid @RequestBody StatusRequestDTO dto) {
        return service.update(idStatus, dto);
    }

    @DeleteMapping("/delete/status/{idStatus}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void delete(@PathVariable Long idStatus) {
        service.delete(idStatus);
    }
}
