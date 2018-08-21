package com.library.controller;

import com.library.domain.dto.BookCopiesDto;
import com.library.domain.dto.BookDto;
import com.library.domain.dto.ReaderDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @RequestMapping(method = RequestMethod.POST, value = "addBook")
    public void addBook(@RequestBody BookDto bookDto) {

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteBook")
    public void removeBook(@RequestParam int titleId) {

    }
    @RequestMapping(method = RequestMethod.POST, value = "addBookCopy")
    public void addBookCopy(@RequestParam int titleId) {

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteBookCopy")
    public void removeBookCopy(@RequestParam int bookId) {

    }

    @RequestMapping(method = RequestMethod.POST, value = "createUser")
    public void createNewReader(@RequestBody ReaderDto readerDto) {

    }

    @RequestMapping(method = RequestMethod.GET, value = "findBook")
    public BookDto findABook(@RequestParam String bookTitle) {
        return null;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "rentBook")
    public void rentABook(ReaderDto readerDto, BookCopiesDto bookCopiesDto) {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "returnBook")
    public void returnABook(ReaderDto readerDto, BookCopiesDto bookCopiesDto) {

    }

}
