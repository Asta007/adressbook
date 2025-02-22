package com.asta.dev.adressbook.contact.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

//@AllArgsConstructor
@Getter
@Setter
public class ContactNotFoundException extends RuntimeException {

    public ContactNotFoundException(String message) {
        super(message);
    }
}
