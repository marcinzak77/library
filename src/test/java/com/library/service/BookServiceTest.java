package com.library.service;

import com.library.controller.DatabaseErrorException;
import com.library.domain.entities.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    public void shouldAddABook() throws DatabaseErrorException {
        //Given
        Book book = new Book("My author", "My Title", 1999);

        //When
        bookService.addBook(book);
        int id = book.getTitleId();
        String results = bookService.findBook("My Title").getTitle();
        int bookItems = bookService.findBook("My Title").getItemList().size();
        //Then
        assertEquals("My Title", results);
        assertEquals(1, bookItems);
        //Clean-up
        try {
            bookService.deleteBook(id);
        } catch (Exception e) {
            //do nothing
        }
    }
}