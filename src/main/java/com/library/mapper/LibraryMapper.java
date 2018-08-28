package com.library.mapper;

import com.library.domain.dto.BookDto;
import com.library.domain.dto.EntryDto;
import com.library.domain.dto.ItemDto;
import com.library.domain.dto.ReaderDto;
import com.library.domain.entities.Book;
import com.library.domain.entities.Entry;
import com.library.domain.entities.Item;
import com.library.domain.entities.Reader;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
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
                itemDto.getTitleId(),
                itemDto.getBookStatus());
    }

    public ItemDto mapToItemDto(final Item item) {
        return new ItemDto(
                item.getBookId(),
                item.getTitleId(),
                item.getBookStatus());
    }

    public List<ItemDto> mapToItemDtoList(final List<Item> itemList) {
        return itemList.stream().map(item -> mapToItemDto(item)).collect(Collectors.toList());
    }

    public Entry mapToEntry(final EntryDto entryDto) {
        return new Entry(
                entryDto.getBookId(),
                entryDto.getReaderId(),
                entryDto.getDateOfRental());
    }

    public EntryDto mapToEntryDto(final Entry entry) {
        return new EntryDto(
                entry.getEntryId(),
                entry.getBookId(),
                entry.getReaderId(),
                entry.getDateOfRental(),
                entry.getDateOfReturn());
    }

    public Reader mapToReader(final ReaderDto readerDto) {
        return new Reader(
                readerDto.getName(),
                readerDto.getSurname());
    }

    public ReaderDto mapToReaderDto(final Reader reader) {
        return new ReaderDto(
                reader.getName(),
                reader.getSurname());
    }
}
