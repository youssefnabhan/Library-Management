package com.personal.librarymanagement.controllers;

import com.personal.librarymanagement.models.BorrowRecord;
import com.personal.librarymanagement.services.BorrowService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class BorrowController {

    private BorrowService borrowService;

    @PostMapping("/borrow/{bookId}/patron/{patronId}")
    public BorrowRecord borrowBook(@PathVariable("bookId") BigInteger bookId,@PathVariable("patronId") BigInteger patronId){
        return borrowService.borrowBook(patronId,bookId);
    }
    @PutMapping("/return/{bookId}/patron/{patronId}")
    public void returnBook (@PathVariable("bookId") BigInteger bookId,@PathVariable("patronId") BigInteger patronId){
        borrowService.returnBook(patronId,bookId);
    }
}
