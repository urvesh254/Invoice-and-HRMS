package com.itaims.ihs.error;

import com.itaims.ihs.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    /**
     * @param exc
     * @return
     * @brief CustomException Handling
     */
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException exc) {
        ErrorResponse error = new ErrorResponse();
        error.setStatus(exc.getStatus().value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, exc.getStatus());
    }

    /**
     * @param exc
     * @return
     * @brief Any exception from rest controller handled here.
     */
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception exc) {

        ErrorResponse error = new ErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage() == null ? "One of the given object is null" : exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    /**
     * @param exc
     * @return
     * @brief Handle access denied exception from rest controller handled here.
     */
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleAccessDenied(AccessDeniedException exc) {

        ErrorResponse error = new ErrorResponse();
        error.setStatus(HttpStatus.UNAUTHORIZED.value());
        error.setMessage(exc.getMessage() == null ? "One of the given object is null" : exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }
}
