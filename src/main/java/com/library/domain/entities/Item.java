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
    private int bookId;
    private int titleId;
    @Column(name = "BOOK_STATUS")
    private String bookStatus;
    public static final String AVAIL = "AVAILABLE";

    public Item(int titleId, String bookStatus) {
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
}
