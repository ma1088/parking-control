package com.api.parkingcontrol.dtos.tenant;

import jakarta.validation.constraints.NotBlank;

public class TenantDto {
    @NotBlank
    String name;

    @NotBlank
    String address;

    @NotBlank
    Long cnpj;
}
