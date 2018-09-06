package com.library.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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
            mappedBy = "book",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Item> itemList;

    public Book(String author, String title, int releaseDate) {
        this.author = author;
        this.title = title;
        this.releaseDate = releaseDate;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return releaseDate == book.releaseDate &&
                Objects.equals(author, book.author) &&
                Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title, releaseDate);
    }
}
