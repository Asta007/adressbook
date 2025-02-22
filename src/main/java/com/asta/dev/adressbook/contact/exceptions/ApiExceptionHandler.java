package com.asta.dev.adressbook.contact.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

    @RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = ContactNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiException HandleContactNotFoundException(ContactNotFoundException e) {
        ApiException apiException = new ApiException(e.getMessage(),LocalDateTime.now());
        return apiException;
    }

    @ExceptionHandler(value = ContactAlreadyExist.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiException HandleContactAlreadyExist (ContactAlreadyExist e) {
        ApiException apiException = new ApiException(e.getMessage(),LocalDateTime.now());
        return apiException;
    }

}
