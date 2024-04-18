package com.personal.librarymanagement.exceptions;

public class BorrowRecordNotFoundException extends NotFoundException {

    public BorrowRecordNotFoundException() {
        super("Borrow record found");
    }
}
