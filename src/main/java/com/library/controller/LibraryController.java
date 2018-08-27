package com.library.controller;

import com.library.domain.dto.EntryDto;
import com.library.domain.dto.ItemDto;
import com.library.domain.dto.BookDto;
import com.library.domain.dto.ReaderDto;
import com.library.mapper.LibraryMapper;
import com.library.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/library")
public class LibraryController {
    private final DbService dbService;
    private final LibraryMapper libraryMapper;

    @RequestMapping(method = RequestMethod.POST, value = "addBook")
    public void addBook(@RequestBody BookDto bookDto) {
        dbService.addBook(libraryMapper.mapToBook(bookDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteBook")
    public void removeBook(@RequestParam int titleId) {
        dbService.deleteBook(titleId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "addBookCopy")
    public void addBookCopy(@RequestParam int titleId) {
        dbService.addBookCopy(titleId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteBookCopy")
    public void removeBookCopy(@RequestParam int bookId) {
        dbService.deleteBookCopy(bookId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createUser")
    public void createNewReader(@RequestBody ReaderDto readerDto) {
        dbService.createNewReader(libraryMapper.mapToReader(readerDto));
    }

    @RequestMapping(method = RequestMethod.GET, value = "findBookTitle")
    public BookDto findBookByTitle(@RequestParam String bookTitle) {
        return libraryMapper.mapToBookDto(dbService.findBook(bookTitle));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "rentBook")
    public void rentABook(@RequestParam EntryDto entryDto) {
        dbService.rentABook(libraryMapper.mapToEntry(entryDto).getBookId());
    }

    @RequestMapping(method = RequestMethod.PUT, value = "returnBook")
    public void returnABook(ReaderDto readerDto, ItemDto itemDto) {

    }

}
