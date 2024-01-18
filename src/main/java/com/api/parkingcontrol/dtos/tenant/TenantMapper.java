package com.api.parkingcontrol.dtos.tenant;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.lang.NonNull;

import com.api.parkingcontrol.model.Tenant;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TenantMapper {

    @Mapping(target = "registrationDate", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "responsiblePerson.id", source = "responsiblePerson")
    public @NonNull Tenant fromTenantDtoToTenant(TenantDto dto);
}
