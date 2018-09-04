package com.library.controller;

import com.library.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/library")
@CrossOrigin(origins = "*")
public class ItemController {
    private final ItemService itemService;

    @PostMapping(value = "addItem")
    public void addBookCopy(@RequestParam int titleId) {
        itemService.addItem(titleId);
    }

    @DeleteMapping(value = "deleteItem")
    public void removeBookCopy(@RequestParam int bookId) {
        itemService.deleteItem(bookId);
    }

}
