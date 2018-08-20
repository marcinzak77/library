package com.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "BOOK")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long titleId;
    @Column(name = "author")
    private String author;
    @Column(name = "title")
    private String title;
    @Column(name = "releasedate")
    private int releaseDate;
}
