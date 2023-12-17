package com.api.parkingcontrol.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public ParkingSpot saveParkingSpot(ParkingSpot parkingSpot) {
        validate(parkingSpot);
        return repository.save(parkingSpot);
    }

    private void validate(ParkingSpot parkingSpot) {
        if (repository.existsByLicensePlateCar(parkingSpot.getLicensePlateCar()))
            throw new ParkingSpotConflictException("car already has a parking spot.");
        if (repository.existsByParkingSpotNumber(parkingSpot.getParkingSpotNumber()))
            throw new ParkingSpotConflictException("parking spot already in use.");
        if (repository.existsByApartmentAndBlock(parkingSpot.getApartment(), parkingSpot.getBlock()))
            throw new ParkingSpotConflictException("unit already has a car registered for a parking spot");
    }

    public Page<ParkingSpot> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public ParkingSpot findOne(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ParkingSpotNotFoundException(id));
    }

    public void deleteParkingSpot(UUID id) {
        ParkingSpot parkingSpot = findOne(id);
        repository.delete(parkingSpot);
    }

    public ParkingSpot updateParkingSpot(UUID id, ParkingSpot parkingSpot){
        ParkingSpot parkingSpotBefore = findOne(id);
        parkingSpot.setId(id);
        parkingSpot.setRegistrationDate(parkingSpotBefore.getRegistrationDate());
        return repository.save(parkingSpot);
    }

}