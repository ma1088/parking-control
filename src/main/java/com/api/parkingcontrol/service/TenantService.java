package com.api.parkingcontrol.service;

import java.util.Objects;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.api.parkingcontrol.exception.tenant.TenantNotFoundException;
import com.api.parkingcontrol.model.Tenant;
import com.api.parkingcontrol.repository.TenantRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TenantService {
    final TenantRepository repository;

    public Tenant create(@NonNull Tenant tenant) {
        return repository.save(tenant);
    }

    public Tenant updateTenant(@NonNull UUID id, Tenant tenant) {
        Tenant tenantBefore = findOne(id);
        tenant.setId(tenantBefore.getId());
        return repository.save(tenant);
    }

    public void deleteTenant(@NonNull UUID id) {
        Tenant tenant = findOne(id);
        repository.delete(tenant);
    }

    public Page<Tenant> getAll(@NonNull Pageable pageable) {
        return repository.findAll(pageable);
    }

    public @NonNull Tenant findOne(@NonNull UUID id) {
        Tenant tenant = repository.findById(id).orElseThrow(() -> new TenantNotFoundException(id));
        if (Objects.isNull(tenant))
            return new Tenant();
        else
            return tenant;
    }

}
