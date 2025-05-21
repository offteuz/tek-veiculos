package br.com.api.tekveiculos.mapper;

import br.com.api.tekveiculos.dto.request.VehicleRequestDTO;
import br.com.api.tekveiculos.dto.response.VehicleResponseDTO;
import br.com.api.tekveiculos.model.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        uses = {StatusMapperHelper.class},
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface VehicleMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "audit", ignore = true)
    @Mapping(source = "statusId", target = "status")
    Vehicle toDTO(VehicleRequestDTO dto);

    VehicleResponseDTO toModel(Vehicle vehicle);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "audit", ignore = true)
    @Mapping(source = "statusId", target = "status")
    void update(VehicleRequestDTO dto, @MappingTarget Vehicle vehicle);
}
