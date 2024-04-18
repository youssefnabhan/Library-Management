package com.personal.librarymanagement.services;

import com.personal.librarymanagement.exceptions.BookBorrowedException;
import com.personal.librarymanagement.exceptions.BookNotFoundException;
import com.personal.librarymanagement.exceptions.BorrowRecordNotFoundException;
import com.personal.librarymanagement.exceptions.PatronNotFoundException;
import com.personal.librarymanagement.models.Book;
import com.personal.librarymanagement.models.BorrowRecord;
import com.personal.librarymanagement.models.Patron;
import com.personal.librarymanagement.repositories.BookRepository;
import com.personal.librarymanagement.repositories.BorrowRecordRepository;
import com.personal.librarymanagement.repositories.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;
import java.util.Optional;

@Service
public class BorrowService {
    private final BorrowRecordRepository borrowRecordRepository;
    private final BookRepository bookRepository;
    private final PatronRepository patronRepository;

    @Autowired
    public BorrowService(BorrowRecordRepository borrowRecordRepository, BookRepository bookRepository, PatronRepository patronRepository) {
        this.borrowRecordRepository = borrowRecordRepository;
        this.bookRepository = bookRepository;
        this.patronRepository = patronRepository;
    }



    public BorrowRecord borrowBook(BigInteger patronId, BigInteger bookId){
        BorrowRecord record = new BorrowRecord();
        Book book = bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);
        Optional<BorrowRecord> optionalBorrowRecord = borrowRecordRepository.findByBook(book);
        if(optionalBorrowRecord.isPresent() && optionalBorrowRecord.get().getReturnDate() == null){
            throw new BookBorrowedException();
        }

        Patron patron = patronRepository.findById(patronId).orElseThrow(PatronNotFoundException::new);
        record.setPatron(patron);
        record.setBook(book);
        record.setBorrowDate(new Date());
        return borrowRecordRepository.save(record);
    }

    public void returnBook(BigInteger patronId, BigInteger bookId){
        Book book = bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);
        Patron patron = patronRepository.findById(patronId).orElseThrow(PatronNotFoundException::new);

        BorrowRecord borrowRecord = borrowRecordRepository.findByBookAndPatron(book,patron).orElseThrow(BorrowRecordNotFoundException::new);
        borrowRecord.setReturnDate(new Date());
    }

}
