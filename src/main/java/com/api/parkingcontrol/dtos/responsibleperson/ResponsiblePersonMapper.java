package com.api.parkingcontrol.dtos.responsibleperson;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.api.parkingcontrol.model.ResponsiblePerson;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ResponsiblePersonMapper {
    
    @Mapping(target = "registrationDate", expression = "java(java.time.LocalDateTime.now())")
    public ResponsiblePerson fromResponsiblePersonDtoToResponsiblePerson(ResponsiblePersonDto dto);
}
