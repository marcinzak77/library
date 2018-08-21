package com.library.domain;

import com.library.domain.dao.BookDao;
import com.library.domain.dao.BookHireDao;
import com.library.domain.dao.BookCopiesDao;
import com.library.domain.dao.ReaderDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibraryDaoTestSuite {

    @Autowired
    BookDao bookDao;
    @Autowired
    BookHireDao bookHireDao;
    @Autowired
    BookCopiesDao bookCopiesDao;
    @Autowired
    ReaderDao readerDao;

    @Test
    @Transactional
    public void testAddBookWithTheeCopies() {
        //Given
        Book bookTitleOne = new Book("Title 1", "Author 1", 2000);
        BookCopies bookCopyOne = new BookCopies(1, "AVAILABLE");
        BookCopies bookCopyTwo = new BookCopies(1, "AVAILABLE");
        BookCopies bookCopyThree = new BookCopies(1, "RENTED");
        List<BookCopies> bookCopies = new ArrayList<>(Arrays.asList(bookCopyOne, bookCopyTwo, bookCopyThree));
        bookTitleOne.setBookCopies(bookCopies);
        //When
        bookDao.save(bookTitleOne);
        int idBookOne = (int) bookTitleOne.getTitleId();
        bookCopiesDao.save(bookCopyOne);
        int bookCopiesIdOne = (int) bookCopyOne.getBookId();
        bookCopiesDao.save(bookCopyTwo);
        int bookCopiesIdTwo = (int) bookCopyTwo.getBookId();
        bookCopiesDao.save(bookCopyThree);
        int bookCopiesIdThree = (int) bookCopyThree.getBookId();
        System.out.println(idBookOne);
        int result = bookTitleOne.getBookCopies().size();
        //Then
        assertEquals(result, 3);

        //Cleanup
        try {
            bookCopiesDao.deleteById(bookCopiesIdOne);
            bookCopiesDao.deleteById(bookCopiesIdTwo);
            bookCopiesDao.deleteById(bookCopiesIdThree);
            bookDao.deleteById(idBookOne);
        } catch (Exception e) {
            //do nothing
        }
    }
}
