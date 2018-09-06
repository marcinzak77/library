package com.library.service;

import com.library.controller.DatabaseErrorException;
import com.library.domain.dao.BookDao;
import com.library.domain.dao.ItemDao;
import com.library.domain.entities.Book;
import com.library.domain.entities.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.library.domain.entities.Item.AVAIL;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemDao itemDao;
    private final BookDao bookDao;

    public void addItem(final int titleId){
        Item item = new Item(titleId, AVAIL);
        Book book = bookDao.findById(titleId).orElse(null);
        if (book != null) {
            item.setBook(book);
            itemDao.save(item);
        }
    }

    public void deleteItem(final int bookId) {
        itemDao.deleteById(bookId);
    }

    public List<Item> getAllItems() {
        return itemDao.findAll();
    }

    public void deleteAllBookItems(final int titleId) {
        itemDao.deleteAll();
    }
}
