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
                book.getReleaseDate());
    }

    public Item mapToItem(final ItemDto itemDto) {
        return new Item(
                itemDto.getTitleId(),
                itemDto.getBookStatus());
    }

    public ItemDto mapToItem(final Item item) {
        return new ItemDto(
                item.getTitleId(),
                item.getBookStatus());
    }

    public Entry mapToEntry(final EntryDto entryDto) {
        return new Entry(
                entryDto.getBookId(),
                entryDto.getReaderId(),
                entryDto.getDateOfRental());
    }

    public EntryDto mapToEntryDto(final Entry entry) {
        return new EntryDto(
                entry.getBookId(),
                entry.getReaderId(),
                entry.getDateOfRental());
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
