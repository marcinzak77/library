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

    @PostMapping(value = "addBook")
    public void addBook(@RequestBody BookDto bookDto) {
        bookService.addBook(libraryMapper.mapToBook(bookDto));
    }

    @DeleteMapping(value = "deleteBook")
    public void deleteBook(@RequestParam int titleId) {
        bookService.deleteBook(titleId);
    }

    @GetMapping(value = "getBooks")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping(value = "findBookTitle")
    public BookDto findBookByTitle(@RequestParam String bookTitle) {
        return libraryMapper.mapToBookDto(bookService.findBook(bookTitle));
    }


}
