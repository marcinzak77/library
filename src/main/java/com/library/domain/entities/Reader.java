package com.library.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "READER")
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int readerId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "ACCOUNT_CREATION_DATE")
    private LocalDate accountCreationDate;

    public Reader(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.accountCreationDate = LocalDate.now();
    }
}