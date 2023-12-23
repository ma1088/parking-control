package com.api.parkingcontrol.dtos.parkingspot;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.api.parkingcontrol.model.ParkingSpot;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ParkingSpotMapper {


    @Mapping(target = "registrationDate", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "tenant.id", source = "tenantId")
    @Mapping(target = "responsiblePerson.id", source = "responsiblePerson")
    public ParkingSpot fromParkingSpotDtoToParkingSpot(ParkingSpotDto dto);

}
