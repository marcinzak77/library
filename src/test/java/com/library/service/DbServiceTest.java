package com.library.service;

import com.library.domain.entities.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbServiceTest {

    @Autowired
    private DbService dbService;
    @Test
    public void shouldAddABook() {
        //Given
        Book book = new Book("My author", "My Title", 1999);

        //When
        dbService.addBook(book);
        int id = book.getTitleId();
        String results = dbService.findBook("My Title").getTitle();
        //Then
        assertEquals("My Title", results);
        //Clean-up
        try {
            dbService.deleteBook(id);
        } catch (Exception e) {
            //do nothing
        }
    }
}