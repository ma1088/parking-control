package com.api.parkingcontrol.exception.responsibleperson;

import java.util.UUID;

public class ResponsiblePersonNotFoundException extends RuntimeException {
    private static final String MSG = "Responsible person not found";
    private static final String MSG_SUFFIX = " with id ";

    public ResponsiblePersonNotFoundException() {
        super(MSG);
    }

    public ResponsiblePersonNotFoundException(UUID id) {
        super(new StringBuilder(MSG)
                .append(MSG_SUFFIX)
                .append(id.toString())
                .toString());
    }

}
