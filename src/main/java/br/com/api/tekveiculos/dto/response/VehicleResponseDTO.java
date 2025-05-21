package br.com.api.tekveiculos.dto.response;

import br.com.api.tekveiculos.model.Audit;
import br.com.api.tekveiculos.model.Vehicle;
import br.com.api.tekveiculos.model.enumerator.MarkVehicle;
import br.com.api.tekveiculos.model.enumerator.ModelVehicle;
import br.com.api.tekveiculos.model.enumerator.TypeVehicle;

public record VehicleResponseDTO(

        Long id,

        TypeVehicle typeVehicle,

        MarkVehicle markVehicle,

        ModelVehicle modelVehicle,

        String color,

        String yearManufacture,

        String plate,

        String km,

        StatusSummaryResponseDTO status,

        Audit audit
) {

    public VehicleResponseDTO(Vehicle vehicle) {
        this(
                vehicle.getId(),
                vehicle.getTypeVehicle(),
                vehicle.getMarkVehicle(),
                vehicle.getModelVehicle(),
                vehicle.getColor(),
                vehicle.getYearManufacture(),
                vehicle.getPlate(),
                vehicle.getKm(),
                new StatusSummaryResponseDTO(vehicle.getStatus()),
                vehicle.getAudit()
        );
    }
}
