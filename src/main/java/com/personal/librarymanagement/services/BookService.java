package com.personal.librarymanagement.services;

import com.personal.librarymanagement.exceptions.BookNotFoundException;
import com.personal.librarymanagement.models.Book;
import com.personal.librarymanagement.repositories.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;


@Service
public class BookService {

    private final BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    public Book getBook(BigInteger bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(BookNotFoundException::new);
    }

    public Book addBook(Book book) {

        return bookRepository.save(book);
    }

    public Book updateBook(BigInteger bookId, Book book) {
        Book existingBook = bookRepository.findById(bookId)
                .orElseThrow(BookNotFoundException::new);

        BeanUtils.copyProperties(book,existingBook,"id","borrowRecords");
        return bookRepository.save(existingBook);

    }

    public void deleteBook(BigInteger bookId) {
        bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);
        bookRepository.deleteById(bookId);
    }
}
