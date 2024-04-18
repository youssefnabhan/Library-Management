package com.personal.librarymanagement.controllers;

import com.personal.librarymanagement.models.Book;
import com.personal.librarymanagement.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> listBooks(){
        return bookService.listBooks();
    }

    @GetMapping("/{bookId}")
    public Book getBook(@PathVariable("bookId") BigInteger bookId){
        return bookService.getBook(bookId);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }
    @PutMapping("/{bookId}")
    public Book updateBook(@PathVariable("bookId") BigInteger bookId , @RequestBody Book book){
            return bookService.updateBook(bookId,book);
    }

    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable("bookId") BigInteger bookId){
        bookService.deleteBook(bookId);
    }



}
