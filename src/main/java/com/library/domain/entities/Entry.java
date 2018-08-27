package com.library.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "BOOKHIRE")
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int entryId;
    @Column(name = "BOOK_ID")
    private int bookId;
    @Column(name = "READER_ID")
    private int readerId;
    @Column(name = "DATE_OF_RENTAL")
    private LocalDate dateOfRental;
    @Column(name = "DATE_OF_RETURN")
    private LocalDate dateOfReturn;

    public Entry(int bookId, int readerId, LocalDate dateOfRental) {
        this.bookId = bookId;
        this.readerId = readerId;
        this.dateOfRental = dateOfRental;
    }
}
