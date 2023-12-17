package com.api.parkingcontrol.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.parkingcontrol.exception.tenant.TenantNotFoundException;
import com.api.parkingcontrol.model.Tenant;
import com.api.parkingcontrol.repository.TenantRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TenantService {
    final TenantRepository repository;

    public Tenant create(Tenant tenant) {
        return repository.save(tenant);
    }

    public Tenant updateTenant(UUID id, Tenant tenant) {
        Tenant tenantBefore = findOne(id);
        tenant.setId(tenantBefore.getId());
        return repository.save(tenant);
    }

    public void deleteTenant(UUID id) {
        Tenant tenant = findOne(id);
        repository.delete(tenant);
    }

    public Page<Tenant> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Tenant findOne(UUID id) {
        return repository.findById(id).orElseThrow(() -> new TenantNotFoundException(id));
    }

}
