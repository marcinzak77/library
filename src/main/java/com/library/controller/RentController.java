package com.library.controller;

import com.library.domain.entities.Item;
import com.library.service.DbRent;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/library")
public class RentController {
    private final DbRent dbRent;

    @RequestMapping(method = RequestMethod.PUT, value = "borrow")
    public Item borrowBook(@RequestParam int bookId, @RequestParam int readerId) throws DatabaseErrorException {
        return dbRent.borrowBook(bookId, readerId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "return")
    public Item returnBook(@RequestParam int bookId) throws DatabaseErrorException {
        return dbRent.returnBook(bookId);
    }

}
