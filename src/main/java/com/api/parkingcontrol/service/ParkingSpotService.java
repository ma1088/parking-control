package com.api.parkingcontrol.service;

import java.util.Objects;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.api.parkingcontrol.exception.parkingspot.ParkingSpotConflictException;
import com.api.parkingcontrol.exception.parkingspot.ParkingSpotNotFoundException;
import com.api.parkingcontrol.model.ParkingSpot;
import com.api.parkingcontrol.repository.ParkingSpotRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ParkingSpotService {

    final ParkingSpotRepository repository;

    public ParkingSpot saveParkingSpot(@NonNull ParkingSpot parkingSpot) {
        validate(parkingSpot);
        return repository.save(parkingSpot);
    }

    private void validate(ParkingSpot parkingSpot) {
        if (repository.existsByLicensePlateCar(parkingSpot.getLicensePlateCar()))
            throw new ParkingSpotConflictException("car already has a parking spot.");
        if (repository.existsByParkingSpotNumber(parkingSpot.getParkingSpotNumber()))
            throw new ParkingSpotConflictException("parking spot already in use.");
        if (repository.existsByTenantUnit(parkingSpot.getTenantUnit()))
            throw new ParkingSpotConflictException("unit already has a car registered for a parking spot");
    }

    public Page<ParkingSpot> findAll(@NonNull Pageable pageable) {
        return repository.findAll(pageable);
    }

    public @NonNull ParkingSpot findOne(@NonNull UUID id) {
        ParkingSpot parkingSpot = repository.findById(id).orElseThrow(() -> new ParkingSpotNotFoundException(id));
        if (Objects.isNull(parkingSpot))
            return new ParkingSpot();
        else
            return parkingSpot;
    }

    public void deleteParkingSpot(@NonNull UUID id) {
        ParkingSpot parkingSpot = findOne(id);
        repository.delete(parkingSpot);
    }

    public ParkingSpot updateParkingSpot(@NonNull UUID id, ParkingSpot parkingSpot) {
        ParkingSpot parkingSpotBefore = findOne(id);
        parkingSpot.setId(id);
        parkingSpot.setRegistrationDate(parkingSpotBefore.getRegistrationDate());
        return repository.save(parkingSpot);
    }

}