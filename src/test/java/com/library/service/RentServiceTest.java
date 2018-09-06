package com.library.service;

import com.library.domain.entities.Book;
import com.library.domain.entities.Reader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.library.domain.entities.Item.AVAIL;
import static com.library.domain.entities.Item.NOTAVAIL;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RentServiceTest {
    @Autowired
    private RentService rentService;
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

    @Test
    public void shouldBorrowBook() {
        //Given
        Reader reader = new Reader("John", "Smith");
        Book book = new Book("Test Author", "Test Title", 2000);
        bookService.addBook(book);
        userService.saveReader(reader);
        int titleId = book.getTitleId();
        int bookId = bookService.findBook("Test Title").getItemList().get(0).getBookId();
        int readerId = reader.getReaderId();
        //When
        try {
            rentService.borrowBook(bookId, readerId);

        } catch (Exception e) {
            System.out.println("book" + bookId + " or reader" + readerId + " not exist: " + e);
        }
        String status = bookService.findBook("Test Title").getItemList().get(0).getBookStatus();
        int resultId = bookService.findBook("Test Title").getItemList().get(0).getReader().getReaderId();
        //Then
        assertEquals(NOTAVAIL, status);
        assertEquals(readerId, resultId);

        //Clean-up
        try {
            bookService.deleteBook(titleId);
            userService.deleteReader(readerId);

        } catch (Exception e) {
            // do nothing
        }
    }

    @Test
    public void shouldReturnBorrowedBook() {
        //Given
        Reader reader = new Reader("John", "Smith");
        Book book = new Book("Test Author", "Test Title", 2000);
        bookService.addBook(book);
        userService.saveReader(reader);
        int titleId = book.getTitleId();
        int bookId = bookService.findBook("Test Title").getItemList().get(0).getBookId();
        int readerId = reader.getReaderId();
        //When
        try {
            rentService.borrowBook(bookId, readerId);
            rentService.returnBook(bookId);
        } catch (Exception e) {
            //do nothing
        }
        String status = bookService.findBook("Test Title").getItemList().get(0).getBookStatus();
        //Then
        assertEquals(AVAIL, status);


        //Clean-up
        try {
            //  userService.deleteReader(readerId);
            //  bookService.deleteBook(titleId);
        } catch (Exception e) {
            // do nothing
        }
    }

}