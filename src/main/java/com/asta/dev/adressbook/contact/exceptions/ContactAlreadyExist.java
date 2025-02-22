package com.asta.dev.adressbook.contact.exceptions;

import lombok.Getter;
import lombok.Setter;

//@AllArgsConstructor
@Getter
@Setter
public class ContactAlreadyExist extends RuntimeException {

    public ContactAlreadyExist(String message) {
        super(message);
    }
}
