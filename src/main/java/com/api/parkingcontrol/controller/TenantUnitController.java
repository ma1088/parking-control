package com.api.parkingcontrol.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.parkingcontrol.dtos.tenantunit.TenantUnitDto;
import com.api.parkingcontrol.dtos.tenantunit.TenantUnitMapper;
import com.api.parkingcontrol.model.TenantUnit;
import com.api.parkingcontrol.service.TenantUnitService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/tenantunit")
@AllArgsConstructor
public class TenantUnitController {

    final TenantUnitService service;
    final TenantUnitMapper mapper;

    @PostMapping
    public ResponseEntity<TenantUnit> postTenantUnit(@RequestBody TenantUnitDto entity) {
        
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(mapper.fromTenantUnitDtoToTenantUnit(entity)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TenantUnit> putTenantUnit(@PathVariable @NonNull UUID id, @RequestBody TenantUnitDto entity) {
        TenantUnit tenantUnit = mapper.fromTenantUnitDtoToTenantUnit(entity);
        tenantUnit.setId(id);
        
        return ResponseEntity.ok().body(service.update(tenantUnit, id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TenantUnit> getById(@RequestParam @NonNull UUID id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
    
    @GetMapping()
    public ResponseEntity<Page<TenantUnit>> getAll(
            @PageableDefault(page = 0, size = 10, sort = "registrationDate", direction = Direction.ASC) @NonNull Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTenantUnit(@PathVariable @NonNull UUID id){
        service.delete(id);
        return ResponseEntity.ok().body(null);
    }
    
}
