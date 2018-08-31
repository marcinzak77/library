package com.library.controller;

import com.library.domain.dto.BookDto;
import com.library.domain.entities.Book;
import com.library.mapper.LibraryMapper;
import com.library.service.DbBook;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/library")
public class BookController {
    private final DbBook dbBook;
    private final LibraryMapper libraryMapper;

    @RequestMapping(method = RequestMethod.POST, value = "addBook")
    public void addBook(@RequestBody BookDto bookDto) {
        dbBook.addBook(libraryMapper.mapToBook(bookDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteBook")
    public void deleteBook(@RequestParam int titleId) {
        dbBook.deleteBook(titleId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBooks")
    public List<Book> getAllBooks() {
        return dbBook.getAllBooks();
    }

    @RequestMapping(method = RequestMethod.GET, value = "findBookTitle")
    public BookDto findBookByTitle(@RequestParam String bookTitle) {
        return libraryMapper.mapToBookDto(dbBook.findBook(bookTitle));
    }


}
