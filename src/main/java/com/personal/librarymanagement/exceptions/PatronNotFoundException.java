package com.personal.librarymanagement.exceptions;

public class PatronNotFoundException extends NotFoundException {

    public PatronNotFoundException() {
        super("Patron not found");
    }
}
