package com.library.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private int titleId;
    private String author;
    private String title;
    private int releaseDate;
    private List<ItemDto> items;
}
