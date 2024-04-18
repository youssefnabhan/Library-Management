package com.personal.librarymanagement.repositories;

import com.personal.librarymanagement.models.Patron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
@Repository
public interface PatronRepository extends JpaRepository<Patron, BigInteger> {
}
