package com.library.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "BOOK")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int titleId;
    @Column(name = "AUTHOR")
    private String author;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "RELEASE_DATE")
    private int releaseDate;

    @OneToMany(
            targetEntity = Item.class,
            mappedBy = "titleId",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Item> bookCopies;

    public Book(String author, String title, int releaseDate) {
        this.author = author;
        this.title = title;
        this.releaseDate = releaseDate;
    }

    public void setBookCopies(List<Item> bookCopies) {
        this.bookCopies = bookCopies;
    }

    public List<Item> getBookCopies() {
        return bookCopies;
    }

    public int getTitleId() {
        return titleId;
    }
}
