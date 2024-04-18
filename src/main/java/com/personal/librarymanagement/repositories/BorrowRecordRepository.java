package com.personal.librarymanagement.repositories;

import com.personal.librarymanagement.models.Book;
import com.personal.librarymanagement.models.BorrowRecord;
import com.personal.librarymanagement.models.Patron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, BigInteger> {
    Optional<BorrowRecord> findByBook(Book book);

    Optional<BorrowRecord> findByBookAndPatron(Book book, Patron patron);
}
