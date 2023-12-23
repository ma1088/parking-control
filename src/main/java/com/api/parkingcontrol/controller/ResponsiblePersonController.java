package com.api.parkingcontrol.controller;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.parkingcontrol.dtos.responsibleperson.ResponsiblePersonDto;
import com.api.parkingcontrol.dtos.responsibleperson.ResponsiblePersonMapper;
import com.api.parkingcontrol.model.ResponsiblePerson;
import com.api.parkingcontrol.service.ResponsiblePersonService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/responsibleperson")
public class ResponsiblePersonController {

    private final ResponsiblePersonMapper mapper;
    private final ResponsiblePersonService service;

    @PostMapping
    public ResponseEntity<ResponsiblePerson> postResponsiblePerson(@RequestBody @Valid ResponsiblePersonDto dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(mapper.fromResponsiblePersonDtoToResponsiblePerson(dto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponsiblePerson> putResponsiblePerson(@PathVariable UUID id,
            @RequestBody @Valid ResponsiblePersonDto dto) {

        return ResponseEntity.ok()
                .body(service.updateResponsiblePerson(id, mapper.fromResponsiblePersonDtoToResponsiblePerson(dto)));
    }

    @GetMapping
    public ResponseEntity<Page<ResponsiblePerson>> getAllResponsiblePerson(
            @PageableDefault(page = 0, size = 10, sort = "registrationDate", direction = Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponsiblePerson> getByIdResponsiblePerson(@PathVariable UUID id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteResponsiblePerson(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.ok().body("");
    }
}
