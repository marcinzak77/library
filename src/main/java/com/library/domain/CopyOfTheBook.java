package com.library.domain;

import javax.persistence.*;

@Entity
@Table(name ="COPYOFTHEBOOK")
public class CopyOfTheBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookId;
    @Column(name = "titleid")
    private long titleId;
    @Column(name = "booksstatus")
    private String bookStatus;

}
