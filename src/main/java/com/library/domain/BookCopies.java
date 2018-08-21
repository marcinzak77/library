package com.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@Entity(name = "BOOKCOPIES")
public class BookCopies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;
    private int titleId;
    @Column(name = "BOOK_STATUS")
    private String bookStatus;

    public BookCopies() {
    }

    public BookCopies(int titleId, String bookStatus) {
        this.titleId = titleId;
        this.bookStatus = bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }
    @ManyToOne
    @JoinColumn(name = "TITLE_ID")
    public int getTitleId() {
        return titleId;
    }

    public int getBookId() {
        return bookId;
    }
}
