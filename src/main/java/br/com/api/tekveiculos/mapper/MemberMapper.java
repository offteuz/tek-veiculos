package br.com.api.tekveiculos.mapper;

import br.com.api.tekveiculos.dto.request.MemberRequestDTO;
import br.com.api.tekveiculos.dto.response.MemberResponseDTO;
import br.com.api.tekveiculos.model.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        uses = {StatusMapperHelper.class},
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface MemberMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "audit", ignore = true)
    @Mapping(target = "visitClients", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    @Mapping(source = "statusId", target = "status")
    Member toDTO(MemberRequestDTO dto);

    MemberResponseDTO toModel(Member member);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "audit", ignore = true)
    @Mapping(target = "visitClients", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    @Mapping(source = "statusId", target = "status")
    void update(MemberRequestDTO dto, @MappingTarget Member member);
}
