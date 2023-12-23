package com.api.parkingcontrol.dtos.responsibleperson;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.api.parkingcontrol.model.ResponsiblePerson;

@Mapper(componentModel = "spring")
public interface ResponsiblePersonMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "registrationDate", expression = "java(java.time.LocalDateTime.now())")
    public ResponsiblePerson fromResponsiblePersonDtoToResponsiblePerson(ResponsiblePersonDto dto);
}
