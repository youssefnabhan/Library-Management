package com.personal.librarymanagement.controllers;

import com.personal.librarymanagement.models.Patron;
import com.personal.librarymanagement.services.PatronService;
import com.personal.librarymanagement.services.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/patrons")
public class PatronController {

    private final PatronService patronService;

    @Autowired
    public PatronController(PatronService patronService) {
        this.patronService = patronService;
    }

    @GetMapping
    public List<Patron> listPatrons(){
        return patronService.listPatrons();
    }

    @GetMapping("/{patronId}")
    public Patron getPatron(@PathVariable("patronId") BigInteger patronId){
        return patronService.getPatron(patronId);
    }

    @PostMapping
    public Patron addPatron(@RequestBody Patron patron){
        return patronService.addPatron(patron);
    }
    @PutMapping("/{patronId}")
    public Patron updatePatron(@PathVariable("patronId") BigInteger patronId , @RequestBody Patron patron){
            return patronService.updatePatron(patronId,patron);
    }

    @DeleteMapping("/{patronId}")
    public void deletePatron(@PathVariable("patronId") BigInteger patronId){
        patronService.deletePatron(patronId);
    }



}
