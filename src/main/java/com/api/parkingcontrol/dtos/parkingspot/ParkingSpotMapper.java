package com.api.parkingcontrol.dtos.parkingspot;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.api.parkingcontrol.model.ParkingSpot;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ParkingSpotMapper {

    public ParkingSpot fromParkingSpotDtoToParkingSpot(ParkingSpotDto dto);

}
