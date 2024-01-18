package com.api.parkingcontrol.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.parkingcontrol.dtos.parkingspot.ParkingSpotDto;
import com.api.parkingcontrol.dtos.parkingspot.ParkingSpotMapper;
import com.api.parkingcontrol.model.ParkingSpot;
import com.api.parkingcontrol.service.ParkingSpotService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parkingspot")
public class ParkingSpotController {

    final ParkingSpotService service;
    final ParkingSpotMapper mapper;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<ParkingSpot> saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto) {
        ParkingSpot parkingSpot = mapper.fromParkingSpotDtoToParkingSpot(parkingSpotDto);
        parkingSpot.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveParkingSpot(parkingSpot));
    }

    @GetMapping
    public ResponseEntity<Page<ParkingSpot>> getAll(
            @PageableDefault(page = 0, size = 10, sort = "registrationDate", direction = Direction.ASC) @NonNull Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingSpot> getOne(@PathVariable(value = "id") @NonNull UUID id) {
        return ResponseEntity.ok().body(service.findOne(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") @NonNull  UUID id) {
        service.deleteParkingSpot(id);
        return ResponseEntity.ok().body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParkingSpot> put(@PathVariable(value = "id") @NonNull UUID id,
            @RequestBody @Valid ParkingSpotDto parkingSpotDto) {
        return ResponseEntity.ok()
                .body(service.updateParkingSpot(id, mapper.fromParkingSpotDtoToParkingSpot(parkingSpotDto)));
    }

}
