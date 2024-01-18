package com.api.parkingcontrol.controller;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.parkingcontrol.dtos.tenant.TenantDto;
import com.api.parkingcontrol.dtos.tenant.TenantMapper;
import com.api.parkingcontrol.model.Tenant;
import com.api.parkingcontrol.service.TenantService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/tenant")
public class TenantController {

    final TenantService service;
    final TenantMapper mapper;

    @PostMapping
    public ResponseEntity<Tenant> saveTenant(@RequestBody @Valid TenantDto entity) {
        Tenant tenant = mapper.fromTenantDtoToTenant(entity);

        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(tenant));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tenant> updateTenant(@PathVariable @NonNull UUID id, @RequestBody @Valid TenantDto entity) {
        Tenant tenant = mapper.fromTenantDtoToTenant(entity);

        return ResponseEntity.ok().body(service.updateTenant(id, tenant));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Tenant> deleteTenant(@PathVariable @NonNull UUID id) {
        service.deleteTenant(id);
        return ResponseEntity.ok().body(null);
    }

    @GetMapping
    public ResponseEntity<Page<Tenant>> getAll(
            @PageableDefault(page = 0, size = 10, sort = "registrationDate", direction = Direction.ASC) @NonNull Pageable pageable) {
        return ResponseEntity.ok().body(service.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tenant> getOne(@PathVariable @NonNull UUID id) {
        return ResponseEntity.ok().body(service.findOne(id));
    }

}
