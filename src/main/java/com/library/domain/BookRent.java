package com.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "BOOKHIRE")
public class BookRent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long hireId;
    @Column(name = "BOOK_ID")
    private long bookId;
    @Column(name = "READER_ID")
    private long readerId;
    @Column(name = "DATE_OF_RENTAL")
    private LocalDate dateOfRental;
    @Column(name = "DATE_OF_RETURN")
    private LocalDate dateOfReturn;

    public BookRent(long bookId, long readerId, LocalDate dateOfRental) {
        this.bookId = bookId;
        this.readerId = readerId;
        this.dateOfRental = dateOfRental;
    }
}
