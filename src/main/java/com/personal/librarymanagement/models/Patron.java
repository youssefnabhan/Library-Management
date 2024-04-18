package com.personal.librarymanagement.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Patron {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @NotBlank
    private String name;

    @NotBlank
    @Pattern(regexp = "^\\d{11}$")
    private String phone;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patron", cascade = CascadeType.ALL)
    private List<BorrowRecord> borrowRecords;

}
