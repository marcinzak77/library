package com.library.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ITEM")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BOOK_ID")
    private int bookId;
    @Column(name = "TITLE_ID")
    private int titleId;
    @Column(name = "BOOK_STATUS")
    private String bookStatus;
    @ManyToOne
    @JoinColumn(name = "BOOK_TITLE_ID")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "READER_ID")
    private Reader reader;

    public static final String AVAIL = "AVAILABLE";
    public static final String NOTAVAIL = "NOT AVAILABLE";

    public Item(int titleId, String bookStatus) {
        this.titleId = titleId;
        this.bookStatus = bookStatus;

    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }
}