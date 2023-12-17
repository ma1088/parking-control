package com.api.parkingcontrol.exception.tenant;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TenantNotFoundException extends RuntimeException {
    private static final String MSG = "Tenant not found";
    private static final String MSG_COMPLEMENT = " with id: ";

    public TenantNotFoundException() {
        super(MSG);
    }

    public TenantNotFoundException(UUID id) {
        super(new StringBuilder(MSG)
                .append(MSG_COMPLEMENT)
                .append(id.toString())
                .toString());
    }
}
