package com.api.parkingcontrol.exception;

import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ParkingSpotNotFoundException extends RuntimeException {
    private static final String MSG = "Parking Spot not found";
    private static final String MSG_COMPLEMENT = " with id: ";

    public ParkingSpotNotFoundException() {
        super(MSG);
    }

    public ParkingSpotNotFoundException(UUID id) {
        super(new StringBuilder(MSG)
                .append(MSG_COMPLEMENT)
                .append(id.toString())
                .toString());
    }

}
