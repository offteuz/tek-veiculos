package br.com.api.tekveiculos.dto.request;

import java.time.LocalDateTime;

public record SupplyRequestDTO(

        LocalDateTime supplyDate,

        Long kmCurrentVehicle,

        float liters,

        float valueLiter,

        float valueAll,

        Long visitClientId
) {
}
