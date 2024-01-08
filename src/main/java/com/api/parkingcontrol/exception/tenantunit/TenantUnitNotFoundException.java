package com.api.parkingcontrol.exception.tenantunit;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TenantUnitNotFoundException extends RuntimeException {
    private static final String MSG = "Tenant Unit not found";
    private static final String MSG_COMPLEMENT = " with id: ";

    public TenantUnitNotFoundException() {
        super(MSG);
    }

    public TenantUnitNotFoundException(UUID id) {
        super(new StringBuilder(MSG)
                .append(MSG_COMPLEMENT)
                .append(id.toString())
                .toString());
    }
}
