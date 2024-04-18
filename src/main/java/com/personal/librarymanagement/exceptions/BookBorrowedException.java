package com.personal.librarymanagement.exceptions;

public class BookBorrowedException extends NotFoundException {

    public BookBorrowedException() {
        super("Book already borrowed");
    }
}
