package com.personal.librarymanagement.repositories;

import com.personal.librarymanagement.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface BookRepository extends JpaRepository<Book, BigInteger> {

}
