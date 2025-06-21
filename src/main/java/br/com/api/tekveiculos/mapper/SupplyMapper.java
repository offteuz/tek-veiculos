package br.com.api.tekveiculos.mapper;

import br.com.api.tekveiculos.dto.request.SupplyRequestDTO;
import br.com.api.tekveiculos.model.Supply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        uses = {VisitClientMapperHelper.class},
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface SupplyMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "visitClientId", target = "visitClient")
    Supply toDTO(SupplyRequestDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "visitClientId", target = "visitClient")
    void update(SupplyRequestDTO dto, @MappingTarget Supply supply);
}
