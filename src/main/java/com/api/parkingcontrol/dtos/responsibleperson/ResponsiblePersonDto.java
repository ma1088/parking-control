package com.api.parkingcontrol.dtos.responsibleperson;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    private static final String OR = "|";
    private static final String MASK_LANDLINE_PHONE = "^\\(\\d{2}\\)\\d{4}-\\d{4}$";
    private static final String MASK_MOBILE_PHONE = "^\\(\\d{2}\\)\\d{5}-\\d{4}$";
    private static final String MASK_CPF = "^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$";
    

    @NotBlank
    @Pattern(regexp = MASK_CPF)
    private String cpf;

    @NotBlank
    private String name;

    @NotNull
    private LocalDate birthDate;

    @NotBlank
    @Pattern(regexp = MASK_LANDLINE_PHONE + OR + MASK_MOBILE_PHONE)
    private String phoneNumber;
}
