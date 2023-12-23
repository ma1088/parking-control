package com.api.parkingcontrol.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.parkingcontrol.model.ResponsiblePerson;

public interface ResponsiblePersonRepository extends JpaRepository<ResponsiblePerson, UUID> {
    
}
