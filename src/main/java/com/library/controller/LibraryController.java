package com.library.controller;

import com.library.domain.dto.EntryDto;
import com.library.domain.dto.BookDto;
import com.library.domain.dto.ReaderDto;
import com.library.domain.entities.Book;
import com.library.domain.entities.Item;
import com.library.domain.entities.Reader;
import com.library.mapper.LibraryMapper;
import com.library.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/library")
public class LibraryController {
    private final DbService dbService;
    private final LibraryMapper libraryMapper;


    @RequestMapping(method = RequestMethod.POST, value = "addItem")
    public void addBookCopy(@RequestParam int titleId) {
        dbService.addItem(titleId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteItem")
    public void removeBookCopy(@RequestParam int bookId) {
        dbService.deleteItem(bookId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createUser")
    public void createNewReader(@RequestBody ReaderDto readerDto) {
        dbService.saveReader(libraryMapper.mapToReader(readerDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateUser")
    public Reader updateReader(@RequestBody ReaderDto readerDto) {
        return dbService.saveReader(libraryMapper.mapToReader(readerDto));
    }

    @RequestMapping(method = RequestMethod.GET, value = "findBookTitle")
    public BookDto findBookByTitle(@RequestParam String bookTitle) {
        return libraryMapper.mapToBookDto(dbService.findBook(bookTitle));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "borrow")
    public Item borrowBook(@RequestParam int bookId, @RequestParam int readerId) throws NotFoundException {
        return dbService.borrowBook(bookId, readerId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "return")
    public Item returnBook(@RequestParam int bookId) throws NotFoundException {
        return dbService.returnBook(bookId);
    }

}
