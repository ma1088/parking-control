package com.api.parkingcontrol.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ParkingSpotConflictException extends RuntimeException {
    private static final String MSG_PREFIX = "Parking Spot Conflict";
    private static final String SEPARATOR = ": ";
    
    public ParkingSpotConflictException(){
        super(MSG_PREFIX);
    }

    public ParkingSpotConflictException(String msg){
        super(new StringBuilder().append(MSG_PREFIX).append(SEPARATOR).append(msg).toString());
    }
}
