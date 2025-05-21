package br.com.api.tekveiculos.mapper;

import br.com.api.tekveiculos.dto.request.ClientRequestDTO;
import br.com.api.tekveiculos.dto.response.ClientResponseDTO;
import br.com.api.tekveiculos.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        uses = {StatusMapperHelper.class},
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ClientMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "audit", ignore = true)
    @Mapping(source = "statusId", target = "status")
    Client toDTO(ClientRequestDTO dto);

    ClientResponseDTO toModel(Client client);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "audit", ignore = true)
    @Mapping(source = "statusId", target = "status")
    void update(ClientRequestDTO dto, @MappingTarget Client client);
}
