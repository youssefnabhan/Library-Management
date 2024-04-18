package com.personal.librarymanagement.exceptions;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class PatronNotFoundException extends NotFoundException {

    public PatronNotFoundException() {
        super("Patron not found");
    }
}
