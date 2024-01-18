package com.api.parkingcontrol.service;

import java.util.Objects;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.api.parkingcontrol.exception.responsibleperson.ResponsiblePersonNotFoundException;
import com.api.parkingcontrol.model.ResponsiblePerson;
import com.api.parkingcontrol.repository.ResponsiblePersonRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ResponsiblePersonService {

    private final ResponsiblePersonRepository repository;

    public ResponsiblePerson create(@NonNull ResponsiblePerson entity) {
        return repository.save(entity);
    }

    public @NonNull ResponsiblePerson findById(@NonNull UUID id) {
        ResponsiblePerson responsibleperson = repository.findById(id)
                .orElseThrow(() -> new ResponsiblePersonNotFoundException(id));
        if (Objects.isNull(responsibleperson))
            return new ResponsiblePerson();
        else
            return responsibleperson;
    }

    public ResponsiblePerson updateResponsiblePerson(@NonNull UUID id, ResponsiblePerson entity) {
        entity.setId(findById(id).getId());
        return repository.save(entity);
    }

    public Page<ResponsiblePerson> findAll(@NonNull Pageable pageable) {
        return repository.findAll(pageable);
    }

    public void delete(@NonNull UUID id) {
        repository.delete(findById(id));
    }
}
