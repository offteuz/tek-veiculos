package br.com.api.tekveiculos.controller;

import br.com.api.tekveiculos.dto.request.VehicleRequestDTO;
import br.com.api.tekveiculos.dto.response.VehicleResponseDTO;
import br.com.api.tekveiculos.service.VehicleService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService service) {
        this.vehicleService = service;
    }

    @PostMapping("/create/vehicle")
    @ResponseStatus(HttpStatus.CREATED)
    public VehicleResponseDTO create(@Valid @RequestBody VehicleRequestDTO dto) {
        return vehicleService.create(dto);
    }

    @GetMapping("/find-all/vehicle")
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            description = "Retorna uma lista de veículos, contendo todos os seus respectivos atributos.",
            summary = "Retorna uma lista de veículos.",
            method = "GET"
    )
    public List<VehicleResponseDTO> findAll() {
        return vehicleService.findAll();
    }

    @GetMapping("/find-by-id/vehicle/{idVehicle}")
    @ResponseStatus(HttpStatus.OK)
    public VehicleResponseDTO findById(@PathVariable Long idVehicle) {
        return vehicleService.findById(idVehicle);
    }

    @PutMapping("/update/vehicle/{idVehicle}")
    @ResponseStatus(HttpStatus.OK)
    public VehicleResponseDTO update(@PathVariable Long idVehicle, @Valid @RequestBody VehicleRequestDTO dto) {
        return vehicleService.update(idVehicle, dto);
    }

    @DeleteMapping("/delete/vehicle/{idVehicle}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long idVehicle) {
        vehicleService.delete(idVehicle);
    }
}
