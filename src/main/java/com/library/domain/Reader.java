package com.library.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "READER")
public class Reader {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private long resaderId;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "accountcreationdate")
    private LocalDate accountCreationDate;
}
