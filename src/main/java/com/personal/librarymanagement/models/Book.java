package com.personal.librarymanagement.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.ISBN;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.math.BigInteger;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @NotBlank
    private String title;

    private String author;

    @Column(name = "publication_year")
    private String publicationYear;

    @Column(unique = true)
    @ISBN
    @NotBlank
    private String isbn;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<BorrowRecord> borrowRecords;

}
