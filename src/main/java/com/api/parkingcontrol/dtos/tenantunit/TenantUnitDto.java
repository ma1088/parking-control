package com.api.parkingcontrol.dtos.tenantunit;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TenantUnitDto {
    
    @NotNull
    private UUID responsiblePersonId;

    @NotBlank
    @Size(max = 20)
    private String unitName;
    
    @NotBlank
    private String block;

    @NotNull
    private UUID tenantId;
}
