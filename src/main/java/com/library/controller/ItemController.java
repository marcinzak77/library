package com.library.controller;

import com.library.service.DbItem;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class ItemController {
    private final DbItem dbItem;

    @RequestMapping(method = RequestMethod.POST, value = "addItem")
    public void addBookCopy(@RequestParam int titleId) {
        dbItem.addItem(titleId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteItem")
    public void removeBookCopy(@RequestParam int bookId) {
        dbItem.deleteItem(bookId);
    }

}
