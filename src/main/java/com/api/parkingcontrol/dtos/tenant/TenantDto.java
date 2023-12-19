package com.api.parkingcontrol.dtos.tenant;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TenantDto {
    @NotBlank
    String name;

    @NotBlank
    String address;

    @NotBlank
    Long cnpj;
}
