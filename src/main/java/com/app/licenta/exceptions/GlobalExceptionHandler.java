package com.app.licenta.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.hibernate.StaleObjectStateException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.CONFLICT;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleEntityNotFoundException(EntityNotFoundException entityNotFoundException) {
        ErrorDetail error = new ErrorDetail(entityNotFoundException.getMessage());
        return new ResponseEntity<>(error, NOT_FOUND);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<?> handleIllegalStateException(IllegalStateException ex) {
        ErrorDetail error = new ErrorDetail(ex.getMessage());
        return new ResponseEntity<>(error, CONFLICT);
    }

    @ExceptionHandler(StaleObjectStateException.class)
    public ResponseEntity<?> handleOptimisticLockingException(StaleObjectStateException ex) {
        ErrorDetail error = new ErrorDetail(ex.getMessage());
        return new ResponseEntity<>(error, CONFLICT);
    }

}