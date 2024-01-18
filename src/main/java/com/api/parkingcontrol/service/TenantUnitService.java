package com.api.parkingcontrol.service;

import java.util.Objects;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.api.parkingcontrol.exception.tenantunit.TenantUnitNotFoundException;
import com.api.parkingcontrol.model.TenantUnit;
import com.api.parkingcontrol.repository.TenantUnitRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TenantUnitService {
    final TenantUnitRepository repository;

    public TenantUnit create(@NonNull TenantUnit tenantUnit) {
        return repository.save(tenantUnit);
    }

    public TenantUnit update(TenantUnit tenantUnit, @NonNull UUID id) {
        findById(id);
        tenantUnit.setId(id);

        return repository.save(tenantUnit);
    }

    public @NonNull TenantUnit findById(@NonNull UUID id) {
        TenantUnit tenantUnit = repository.findById(id).orElseThrow(() -> new TenantUnitNotFoundException(id));
        if (Objects.isNull(tenantUnit))
            return new TenantUnit();
        else
            return tenantUnit;
    }

    public Page<TenantUnit> findAll(@NonNull Pageable pageable) {
        return repository.findAll(pageable);
    }

    public void delete(@NonNull UUID id) {
        TenantUnit toBeDeleted = findById(id);
        repository.delete(toBeDeleted);
    }

}
