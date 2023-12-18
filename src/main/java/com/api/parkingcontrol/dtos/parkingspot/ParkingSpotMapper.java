package com.api.parkingcontrol.dtos.parkingspot;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.api.parkingcontrol.model.ParkingSpot;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ParkingSpotMapper {

    @Mapping(target = "tenant.id", source = "tenantId")
    public ParkingSpot fromParkingSpotDtoToParkingSpot(ParkingSpotDto dto);

}
