package com.library.controller;

import com.library.domain.dto.BookDto;
import com.library.domain.entities.Book;
import com.library.mapper.LibraryMapper;
import com.library.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/library")
public class BookController {
    private final DbService dbService;
    private final LibraryMapper libraryMapper;

    @RequestMapping(method = RequestMethod.POST, value = "addBook")
    public void addBook(@RequestBody BookDto bookDto) {
        dbService.addBook(libraryMapper.mapToBook(bookDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteBook")
    public void deleteBook(@RequestParam int titleId) {
        dbService.deleteBook(titleId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBooks")
    public List<Book> getAllBooks() {
        return dbService.getAllBooks();
    }

}
