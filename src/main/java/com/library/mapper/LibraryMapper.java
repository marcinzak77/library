package com.library.mapper;

import com.library.domain.dto.BookDto;
import com.library.domain.dto.EntryDto;
import com.library.domain.dto.ItemDto;
import com.library.domain.entities.Book;
import com.library.domain.entities.Entry;
import com.library.domain.entities.Item;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LibraryMapper {
    public Book mapToBook(final BookDto bookDto) {
        return new Book(
                bookDto.getAuthor(),
                bookDto.getTitle(),
                bookDto.getReleaseDate());
    }

    public BookDto mapToBookDto(final Book book) {
        return new BookDto(
                book.getTitleId(),
                book.getAuthor(),
                book.getTitle(),
                book.getReleaseDate(),
                mapToItemDtoList(book.getItemList()));
    }

    public Item mapToItem(final ItemDto itemDto) {
        return new Item(
                itemDto.getBookTitleId(),
                itemDto.getBookStatus());
    }

    public ItemDto mapToItemDto(final Item item) {
        return new ItemDto(
                item.getItemId(),
                item.getTitleId(),
                item.getBookStatus());
    }

    public List<ItemDto> mapToItemDtoList(final List<Item> itemList) {
        return itemList.stream().map(item -> mapToItemDto(item)).collect(Collectors.toList());
    }

    public Entry mapToEntry(final EntryDto entryDto) {
        return new Entry(
                entryDto.getEntryId(),
                entryDto.getBookId(),
                entryDto.getReaderId(),
                entryDto.getDateOfRental(),
                entryDto.getDateOfReturn());
    }

    public EntryDto mapToEntryDto(final Entry entry) {
        return new EntryDto(
                entry.getEntryId(),
                entry.getBookId(),
                entry.getReaderId(),
                entry.getDateOfRental(),
                entry.getDateOfReturn());
    }


}
