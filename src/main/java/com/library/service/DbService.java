package com.library.service;

import com.library.domain.Book;
import com.library.domain.BookCopies;
import com.library.domain.Reader;
import com.library.domain.dao.BookCopiesDao;
import com.library.domain.dao.BookDao;
import com.library.domain.dao.BookRentDao;
import com.library.domain.dao.ReaderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbService {
    @Autowired
    BookDao bookDao;
    @Autowired
    BookCopiesDao bookCopiesDao;
    @Autowired
    ReaderDao readerDao;
    @Autowired
    BookRentDao bookRentDao;

    public void addBook(final Book book) {
        bookDao.save(book);
    }

    public void deleteBook(final int id) {
        bookDao.deleteById((id));
    }

    public void addBookCopy(final int titleId) {
        BookCopies bookCopies = new BookCopies(titleId, "AVAILABLE");
        bookCopiesDao.save(bookCopies);
    }

    public void deleteBookCopy(final int bookId) {
        bookCopiesDao.deleteById(bookId);
    }

    public void createNewReader(final Reader reader) {
        readerDao.save(reader);
    }

    public Book findBook(final String bookTitle) {
        return null;
    }

    public void rentABook(final int bookId) {

    }

    public void returnABook(final int bookId) {

    }
}
