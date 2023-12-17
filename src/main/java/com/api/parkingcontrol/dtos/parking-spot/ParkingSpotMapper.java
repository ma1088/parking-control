package com.api.parkingcontrol.dtos;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.api.parkingcontrol.model.ParkingSpot;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ParkingSpotMapper {

    public ParkingSpot fromParkingSpotDtoToParkingSpot(ParkingSpotDto dto);

    public ParkingSpotDto fromParkingSpotToParkingSpotDto(ParkingSpot entity);

    public List<ParkingSpot> fromParkingSpotDtoToParkingSpot(List<ParkingSpotDto> dto);

    public List<ParkingSpotDto> fromParkingSpotToParkingSpotDto(List<ParkingSpot> entity);

}
