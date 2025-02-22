package com.asta.dev.adressbook.contact.exceptions;

import lombok.*;

import java.time.LocalDateTime;

//@AllArgsConstructor
@Getter
@Setter
public class ApiException {
    private String message;
    private LocalDateTime timestamp;

    public ApiException(String message, LocalDateTime timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

}
