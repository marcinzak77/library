package com.library.service;

import com.library.domain.dao.BookDao;
import com.library.domain.dao.ItemDao;
import com.library.domain.entities.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.library.domain.entities.Item.AVAIL;

@Service
@RequiredArgsConstructor
public class DbItem {
    private final BookDao bookDao;
    private final ItemDao itemDao;

    public void addItem(final int titleId) {
        Item item = new Item(titleId, AVAIL);
        itemDao.save(item);
    }

    public void deleteItem(final int bookId) {
        itemDao.deleteById(bookId);
    }
}
