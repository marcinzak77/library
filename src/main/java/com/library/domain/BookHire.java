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
public class BookHire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookId;
    @Column(name = "readerid")
    private long resaderId;
    @Column(name = "dateofrental")
    private LocalDate dateOfRental;
    @Column(name = "dateofreturn")
    private LocalDate dateOfReturn;

}
