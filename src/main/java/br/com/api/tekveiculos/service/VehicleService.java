package br.com.api.tekveiculos.service;

import br.com.api.tekveiculos.dto.request.VehicleRequestDTO;
import br.com.api.tekveiculos.dto.response.VehicleResponseDTO;
import br.com.api.tekveiculos.exception.VehicleNotFoundException;
import br.com.api.tekveiculos.mapper.VehicleMapper;
import br.com.api.tekveiculos.model.Vehicle;
import br.com.api.tekveiculos.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    private final VehicleMapper vehicleMapper;

    public VehicleService(VehicleRepository vehicleRepository, VehicleMapper vehicleMapper) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleMapper = vehicleMapper;
    }

    public VehicleResponseDTO create(VehicleRequestDTO dto) {
        Vehicle vehicle = vehicleMapper.toDTO(dto);

        return new VehicleResponseDTO(vehicleRepository.save(vehicle));
    }

    public List<VehicleResponseDTO> findAll() {
        return vehicleRepository.findAll()
                .stream()
                .map(VehicleResponseDTO::new)
                .toList();
    }

    public VehicleResponseDTO findById(Long idVehicle) {
        Vehicle vehicle = vehicleRepository.findById(idVehicle)
                .orElseThrow(VehicleNotFoundException::new);

        return new VehicleResponseDTO(vehicle);
    }

    public VehicleResponseDTO update(Long idVehicle, VehicleRequestDTO dto) {
        Vehicle vehicle = vehicleRepository.findById(idVehicle)
                .orElseThrow(VehicleNotFoundException::new);

        vehicleMapper.update(dto, vehicle);

        return new VehicleResponseDTO(vehicleRepository.save(vehicle));
    }

    public void delete(Long idVehicle) {
        Vehicle vehicle = vehicleRepository.findById(idVehicle)
                .orElseThrow(VehicleNotFoundException::new);

        vehicleRepository.delete(vehicle);
    }
}
