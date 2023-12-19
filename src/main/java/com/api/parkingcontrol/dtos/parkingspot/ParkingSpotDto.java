package com.api.parkingcontrol.dtos.parkingspot;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParkingSpotDto {
    @NotBlank
    private String parkingSpotNumber;
    
    @NotBlank
    @Size(max = 7)
    private String licensePlateCar;

    @NotBlank
    private String brandCar;

    @NotBlank
    private String modelCar;

    @NotBlank
    private String colorCar;

    @NotBlank
    private String responsibleName;

    @NotBlank
    private String apartment;
    
    @NotBlank
    private String block;

    @NotBlank
    private UUID tenantId;
}
