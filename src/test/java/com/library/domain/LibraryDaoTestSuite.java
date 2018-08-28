package com.library.domain;

import com.library.domain.dao.BookDao;
import com.library.domain.dao.BookRentDao;
import com.library.domain.dao.ItemDao;
import com.library.domain.dao.ReaderDao;
import com.library.domain.entities.Book;
import com.library.domain.entities.Item;
import com.library.domain.entities.Reader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.library.domain.entities.Item.AVAIL;
import static com.library.domain.entities.Item.NOTAVAIL;
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
        Item bookCopyOne = new Item(1, AVAIL);
        Item bookCopyTwo = new Item(1, AVAIL);
        Item bookCopyThree = new Item(1, NOTAVAIL);
        List<Item> bookCopies = new ArrayList<>(Arrays.asList(bookCopyOne, bookCopyTwo, bookCopyThree));
        bookTitleOne.setItemList(bookCopies);
        //When
        bookDao.save(bookTitleOne);
        int idBookOne = bookTitleOne.getTitleId();
        itemDao.save(bookCopyOne);
        int bookCopiesIdOne = bookCopyOne.getBookId();
        itemDao.save(bookCopyTwo);
        int bookCopiesIdTwo = bookCopyTwo.getBookId();
        itemDao.save(bookCopyThree);
        int bookCopiesIdThree = bookCopyThree.getBookId();
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

    @Test
    public void shouldCreateUser(){
        //Given
        Reader reader = new Reader("John", "Smith");
        //When
        readerDao.save(reader);
        int id = reader.getReaderId();
        String result = readerDao.findById(id).orElse(new Reader()).getName();
        //Then
        assertEquals("John", result);

        //Clean up
        try {
            readerDao.deleteById(id);
        } catch (Exception e) {
            //do nothing
        }
    }
}
