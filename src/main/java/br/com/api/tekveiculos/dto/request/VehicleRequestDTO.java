package br.com.api.tekveiculos.dto.request;

import br.com.api.tekveiculos.model.enumerator.MarkVehicle;
import br.com.api.tekveiculos.model.enumerator.ModelVehicle;
import br.com.api.tekveiculos.model.enumerator.TypeVehicle;

public record VehicleRequestDTO(

        TypeVehicle typeVehicle,

        MarkVehicle markVehicle,

        ModelVehicle modelVehicle,

        String color,

        String yearManufacture,

        String plate,

        String km,

        Long statusId
) {
}
