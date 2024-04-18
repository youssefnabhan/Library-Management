package com.personal.librarymanagement.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class BorrowRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patron_id")
    private Patron patron;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book;
    @Column(name = "borrow_date")
    private Date borrowDate;
    @Column(name = "return_date")
    private Date returnDate;



}
