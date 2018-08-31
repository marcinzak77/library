package com.library.controller;

import com.library.domain.dto.BookDto;
import com.library.domain.entities.Book;
import com.library.mapper.LibraryMapper;
import com.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/library")
@CrossOrigin(origins = "*")
public class BookController {
    private final BookService bookService;
    private final LibraryMapper libraryMapper;

    @RequestMapping(method = RequestMethod.POST, value = "addBook")
    public void addBook(@RequestBody BookDto bookDto) {
        bookService.addBook(libraryMapper.mapToBook(bookDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteBook")
    public void deleteBook(@RequestParam int titleId) {
        bookService.deleteBook(titleId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBooks")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @RequestMapping(method = RequestMethod.GET, value = "findBookTitle")
    public BookDto findBookByTitle(@RequestParam String bookTitle) {
        return libraryMapper.mapToBookDto(bookService.findBook(bookTitle));
    }


}
