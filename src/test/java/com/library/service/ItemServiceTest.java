package com.library.service;

import com.library.domain.entities.Book;
import com.library.domain.entities.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemServiceTest {
    @Autowired
    private ItemService itemService;
    @Autowired
    private BookService bookService;

    @Test
    public void shouldAddBookItem() {
        //Given
        Book book = new Book("My author", "My Title", 1999);
        bookService.addBook(book);
        int id = book.getTitleId();
        //When
        itemService.addItem(id);
        int results = bookService.findBook("My Title").getItemList().size();
        //Then
        assertEquals(2, results);

        //Clean-up
        try {
            bookService.deleteBook(id);
        } catch (Exception e) {
            //do nothing
        }
    }

}