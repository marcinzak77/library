package com.library.domain;

import com.library.domain.dao.BookDao;
import com.library.domain.dao.BookRentDao;
import com.library.domain.dao.ItemDao;
import com.library.domain.dao.ReaderDao;
import com.library.domain.entities.Book;
import com.library.domain.entities.Item;
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
    BookRentDao bookRentDao;
    @Autowired
    ItemDao itemDao;
    @Autowired
    ReaderDao readerDao;

    @Test
    @Transactional
    public void testAddBookWithThreeCopies() {
        //Given
        Book bookTitleOne = new Book("Title 1", "Author 1", 2000);
        Item bookCopyOne = new Item(1, "AVAILABLE");
        Item bookCopyTwo = new Item(1, "AVAILABLE");
        Item bookCopyThree = new Item(1, "RENTED");
        List<Item> bookCopies = new ArrayList<>(Arrays.asList(bookCopyOne, bookCopyTwo, bookCopyThree));
        bookTitleOne.setItemList(bookCopies);
        //When
        bookDao.save(bookTitleOne);
        int idBookOne = bookTitleOne.getTitleId();
        itemDao.save(bookCopyOne);
        int bookCopiesIdOne = (int) bookCopyOne.getBookId();
        itemDao.save(bookCopyTwo);
        int bookCopiesIdTwo = (int) bookCopyTwo.getBookId();
        itemDao.save(bookCopyThree);
        int bookCopiesIdThree = (int) bookCopyThree.getBookId();
        System.out.println(idBookOne);
        int result = bookTitleOne.getItemList().size();
        //Then
        assertEquals(result, 3);

        //Cleanup
        try {
            itemDao.deleteById(bookCopiesIdOne);
            itemDao.deleteById(bookCopiesIdTwo);
            itemDao.deleteById(bookCopiesIdThree);
            bookDao.deleteById(idBookOne);
        } catch (Exception e) {
            //do nothing
        }
    }
}
