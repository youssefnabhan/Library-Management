package com.personal.librarymanagement.exceptions;

public class BookNotFoundException extends NotFoundException {

    public BookNotFoundException() {
        super("Book not found");
    }
}
