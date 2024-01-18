package com.api.parkingcontrol.dtos.tenantunit;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.lang.NonNull;

import com.api.parkingcontrol.model.TenantUnit;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TenantUnitMapper {

    @Mapping(target = "registrationDate", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "responsiblePerson.id", source = "responsiblePersonId")
    @Mapping(target = "tenant.id", source = "tenantId")
    public @NonNull TenantUnit fromTenantUnitDtoToTenantUnit(TenantUnitDto dto);
}
