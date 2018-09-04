package com.library.controller;

import com.library.domain.entities.Item;
import com.library.service.RentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/library")
@CrossOrigin(origins = "*")
public class RentController {
    private final RentService rentService;

    @PutMapping(value = "borrow")
    public Item borrowBook(@RequestParam int bookId, @RequestParam int readerId) throws DatabaseErrorException {
        return rentService.borrowBook(bookId, readerId);
    }

    @PutMapping(value = "return")
    public Item returnBook(@RequestParam int bookId) throws DatabaseErrorException {
        return rentService.returnBook(bookId);
    }

}
