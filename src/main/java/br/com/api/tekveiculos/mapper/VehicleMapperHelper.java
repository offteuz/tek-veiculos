package br.com.api.tekveiculos.mapper;

import br.com.api.tekveiculos.exception.VehicleNotFoundException;
import br.com.api.tekveiculos.model.Vehicle;
import br.com.api.tekveiculos.repository.VehicleRepository;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapperHelper {

    private final VehicleRepository vehicleRepository;

    public VehicleMapperHelper(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle map(Long idVehicle) {
        return vehicleRepository.findById(idVehicle)
                .orElseThrow(VehicleNotFoundException::new);
    }
}
