package com.api.parkingcontrol.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.parkingcontrol.model.ParkingSpot;
import com.api.parkingcontrol.model.TenantUnit;


public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, UUID> {
    boolean existsByLicensePlateCar(String licensePlateCar);
    boolean existsByParkingSpotNumber(String parkingSpotNumber);
    boolean existsByTenantUnitUnitNameAndTenantUnitBlock(String apartment, String block);
    boolean existsByTenantUnit(TenantUnit tenantUnit);
}
