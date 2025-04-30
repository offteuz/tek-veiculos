package br.com.api.tekveiculos.mapper;

import br.com.api.tekveiculos.dto.request.StatusRequestDTO;
import br.com.api.tekveiculos.dto.response.StatusResponseDTO;
import br.com.api.tekveiculos.model.Status;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface StatusMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "audit", ignore = true)
    Status toDTO(StatusRequestDTO dto);

    StatusResponseDTO toModel(Status status);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "audit", ignore = true)
    void update(StatusRequestDTO dto, @MappingTarget Status status);
}
