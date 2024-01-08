package com.api.parkingcontrol.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.parkingcontrol.exception.tenantunit.TenantUnitNotFoundException;
import com.api.parkingcontrol.model.TenantUnit;
import com.api.parkingcontrol.repository.TenantUnitRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TenantUnitService {
    final TenantUnitRepository repository;

    public TenantUnit create(TenantUnit tenantUnit) {
        return repository.save(tenantUnit);
    }

    public TenantUnit update(TenantUnit tenantUnit, UUID id) {
        findById(id);
        tenantUnit.setId(id);

        return repository.save(tenantUnit);
    }

    public TenantUnit findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new TenantUnitNotFoundException(id));
    }

    public Page<TenantUnit> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public void delete(UUID id) {
        TenantUnit toBeDeleted = findById(id);
        repository.delete(toBeDeleted);
    }

    
    
}
