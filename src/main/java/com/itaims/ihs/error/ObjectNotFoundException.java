package com.itaims.ihs.error;

import org.springframework.http.HttpStatus;

public class ObjectNotFoundException extends CustomException {
    public ObjectNotFoundException() {
    }

    public ObjectNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }

}
