package com.library.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ENTRY")
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int entryId;
    @Column(name = "BOOK_ID")
    private int bookId;
    @Column(name = "READER_ID")
    private int readerId;
    @Column(name = "DATE_OF_LOAN")
    private LocalDate dateOfRental;
    @Column(name = "DATE_OF_RETURN")
    private LocalDate dateOfReturn;

    public Entry(int bookId, int readerId) {
        this.bookId = bookId;
        this.readerId = readerId;
        this.dateOfRental = LocalDate.now();
    }

    public void setDateOfReturn(LocalDate dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }
}
