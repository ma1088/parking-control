package com.api.parkingcontrol.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.parkingcontrol.exception.responsibleperson.ResponsiblePersonNotFoundException;
import com.api.parkingcontrol.model.ResponsiblePerson;
import com.api.parkingcontrol.repository.ResponsiblePersonRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ResponsiblePersonService {

    private final ResponsiblePersonRepository repository;

    public ResponsiblePerson create(ResponsiblePerson entity){
        return repository.save(entity);
    }

    public ResponsiblePerson findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ResponsiblePersonNotFoundException(id));
    }

    public ResponsiblePerson updateResponsiblePerson(UUID id, ResponsiblePerson entity) {
        entity.setId(findById(id).getId());
        return repository.save(entity);
    }

    public Page<ResponsiblePerson> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public void delete(UUID id) {
        repository.delete(findById(id));
    }
}
