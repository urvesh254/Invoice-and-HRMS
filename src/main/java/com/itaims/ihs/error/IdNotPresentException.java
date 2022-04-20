package com.itaims.ihs.error;

import org.springframework.http.HttpStatus;

public class IdNotPresentException extends CustomException {
    public IdNotPresentException() {
    }

    public IdNotPresentException(String message, HttpStatus status) {
        super(message, status);
    }
    public IdNotPresentException(String message) {
        super(message);
    }
}
