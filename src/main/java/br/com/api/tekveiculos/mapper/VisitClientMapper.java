package br.com.api.tekveiculos.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        uses = {VehicleMapperHelper.class, ClientMapperHelper.class, StatusMapperHelper.class},
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface VisitClientMapper {
}
