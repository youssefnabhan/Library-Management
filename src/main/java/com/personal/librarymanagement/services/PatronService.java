package com.personal.librarymanagement.services;

import com.personal.librarymanagement.exceptions.BookNotFoundException;
import com.personal.librarymanagement.exceptions.PatronNotFoundException;
import com.personal.librarymanagement.models.Book;
import com.personal.librarymanagement.models.Patron;
import com.personal.librarymanagement.repositories.PatronRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
@Service
public class PatronService {

    private final PatronRepository patronRepository;

    @Autowired
    public PatronService(PatronRepository patronRepository) {
        this.patronRepository = patronRepository;
    }

    public List<Patron> listPatrons(){
        return patronRepository.findAll();
    }

    public  Patron getPatron(BigInteger patronId){
        return patronRepository.findById(patronId).orElseThrow(PatronNotFoundException::new);
    }

    public Patron addPatron(Patron patron){
        return patronRepository.save(patron);
    }

    public Patron updatePatron(BigInteger patronId,Patron patron){
        Patron existingPatron = patronRepository.findById(patronId)
                .orElseThrow(BookNotFoundException::new);

        BeanUtils.copyProperties(patron,existingPatron,"id","borrowRecords");
        return patronRepository.save(existingPatron);
    }

    public void deletePatron(BigInteger patronId){
        patronRepository.findById(patronId).orElseThrow(PatronNotFoundException::new);
        patronRepository.deleteById(patronId);
    }
}
