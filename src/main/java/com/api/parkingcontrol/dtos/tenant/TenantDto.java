package com.api.parkingcontrol.dtos.tenant;

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

    @NotNull
    String cnpj;
}
