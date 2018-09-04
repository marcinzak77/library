package com.library.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private int titleId;
    @JsonProperty("author")
    private String author;
    @JsonProperty("title")
    private String title;
    @JsonProperty("releaseDate")
    private int releaseDate;
    private List<ItemDto> items;
}
