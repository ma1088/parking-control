package com.api.parkingcontrol.dtos.tenant;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.api.parkingcontrol.model.Tenant;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TenantMapper {

    public Tenant fromTenantDtoToTenant(TenantDto dto);
}
