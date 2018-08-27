package com.library.service;

import com.library.domain.entities.Book;
import com.library.domain.entities.Item;
import com.library.domain.entities.Reader;
import com.library.domain.dao.ItemDao;
import com.library.domain.dao.BookDao;
import com.library.domain.dao.BookRentDao;
import com.library.domain.dao.ReaderDao;
import com.library.mapper.LibraryMapper;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DbService {
    private final BookDao bookDao;
    private final ItemDao itemDao;
    private final ReaderDao readerDao;
    private final BookRentDao bookRentDao;

    public void addBook(final Book book) {
        bookDao.save(book);
    }

    public void deleteBook(final int id) {
        bookDao.deleteById((id));
    }

    public void addBookCopy(final int titleId) {
        Item item = new Item(titleId, "AVAILABLE");
        itemDao.save(item);
    }

    public void deleteBookCopy(final int bookId) {
        itemDao.deleteById(bookId);
    }

    public void createNewReader(final Reader reader) {
        readerDao.save(reader);
    }

    public Book findBook(final String bookTitle) {
        List<Book> bookList = new ArrayList<>();
        bookDao.findAll().forEach(book -> bookList.add(book));
        for (Book findedBook: bookList) {
            if (findedBook.getTitle().equalsIgnoreCase(bookTitle)) {
                return findedBook;
            }
        }
        return new Book();
    }

    public void rentABook(final int bookId) {

    }

    public void returnABook(final int bookId) {

    }
}
