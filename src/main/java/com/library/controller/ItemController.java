package com.library.controller;

import com.library.domain.entities.Item;
import com.library.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "getItems")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

}
