package com.library.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EntryDto {
    private int entryId;
    private int bookId;
    private int readerId;
    private LocalDate dateOfRental;
    private LocalDate dateOfReturn;
}
