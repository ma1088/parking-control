package com.api.parkingcontrol.dtos.responsibleperson;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponsiblePersonDto {

    @NotBlank
    @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$")
    private String cpf;

    @NotBlank
    private String name;

    @NotBlank
    private LocalDate birthDate;

    @NotBlank
    @Pattern(regexp = "^(\\(\\d{2}\\)\\d{4}-\\d{4}|\\(d{2}\\)d{5}\\-d{4})$")
    private String phoneNumber;
}
