package com.api.parkingcontrol.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;

import com.api.parkingcontrol.exception.responsibleperson.ResponsiblePersonNotFoundException;
import com.api.parkingcontrol.model.ResponsiblePerson;
import com.api.parkingcontrol.repository.ResponsiblePersonRepository;

@ExtendWith(MockitoExtension.class)
class ResponsiblePersonServiceTests {
    @InjectMocks
    ResponsiblePersonService service;
    @Mock
    ResponsiblePersonRepository repository;

    @Test
    void createTest() {
        ResponsiblePerson responsiblePersonToSave = getPerson();
        ResponsiblePerson responsiblePerson = getPerson();
        responsiblePerson.setId(UUID.randomUUID());
        when(repository.save(responsiblePersonToSave)).thenReturn(responsiblePerson);

        ResponsiblePerson result = service.create(getPerson());
        assertEquals(responsiblePerson, result);
    }

    @Test
    void updateResponsiblePersonTest() {
        UUID id = getId();
        ResponsiblePerson responsiblePerson = getPerson();
        responsiblePerson.setId(id);
        when(repository.findById(id)).thenReturn(Optional.of(responsiblePerson));
        when(repository.save(responsiblePerson)).thenReturn(responsiblePerson);

        ResponsiblePerson result = service.updateResponsiblePerson(id, responsiblePerson);
        assertEquals(responsiblePerson, result);
    }

    @Test
    void updateResponsiblePersonTestFail() {
        UUID id = getId();
        ResponsiblePerson responsiblePerson = getPerson();
        responsiblePerson.setId(id);
        when(repository.findById(id)).thenAnswer(item -> {
            throw new ResponsiblePersonNotFoundException(id);
        });

        Exception exception = assertThrows(ResponsiblePersonNotFoundException.class, () -> {
            service.updateResponsiblePerson(id, responsiblePerson);
        });

        assertTrue(exception.getMessage().contains(id.toString()));
    }

    @Test
    void deleteTest() {
        UUID id = getId();
        ResponsiblePerson responsiblePerson = getPerson();
        responsiblePerson.setId(id);
        when(repository.findById(id)).thenReturn(Optional.of(responsiblePerson));
        service.delete(id);
        verify(repository, times(1)).delete(responsiblePerson);
    }

    @Test
    void findByIdTest() {
        UUID id = getId();
        ResponsiblePerson responsiblePerson = getPerson();
        responsiblePerson.setId(id);

        when(repository.findById(id)).thenReturn(Optional.of(responsiblePerson));

        ResponsiblePerson result = service.findById(id);
        assertEquals(responsiblePerson, result);
    }

    @Test
    void findByIdTestFail() {
        UUID id = getId();
        ResponsiblePerson responsiblePerson = getPerson();
        responsiblePerson.setId(id);
        when(repository.findById(id)).thenAnswer(item -> {
            throw new ResponsiblePersonNotFoundException(id);
        });

        Exception exception = assertThrows(ResponsiblePersonNotFoundException.class, () -> {
            service.updateResponsiblePerson(id, responsiblePerson);
        });

        assertTrue(exception.getMessage().contains(id.toString()));
    }

    @Test
    void findAllTest() {
        List<ResponsiblePerson> responsiblePersons = List.of();
        when(repository.findAll(Pageable.unpaged())).thenReturn(Page.empty());
        Page<ResponsiblePerson> result = service.findAll(Pageable.unpaged());
        assertEquals(responsiblePersons, result.getContent());
        assertEquals(responsiblePersons.size(), result.getContent().size());
    }

    private @NonNull ResponsiblePerson getPerson() {
        ResponsiblePerson toReturn = ResponsiblePerson.builder()
                .cpf("111.222.333-44")
                .name("Juca Peixoto")
                .birthDate(LocalDate.of(2023, 4, 2))
                .phoneNumber("(11)2222-3333")
                .registrationDate(LocalDateTime.now())
                .build();
        assertNotNull(toReturn);
        return toReturn;
    }

    private @NonNull UUID getId(){
        UUID id = UUID.randomUUID();
        assertNotNull(id);
        return id;
    }

}
