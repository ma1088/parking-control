package com.api.parkingcontrol.dtos.tenant;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TenantDto {
    @NotBlank
    String name;

    @NotBlank
    String address;

    @NotBlank
    String cnpj;

    @NotNull
    UUID responsiblePerson;
}
