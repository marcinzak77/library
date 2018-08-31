package com.library.service;

import com.library.domain.entities.Book;
import com.library.domain.dao.BookDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbBook {
    private final BookDao bookDao;
    private final DbItem dbItem;

    public void addBook(final Book book) {
        if (!findBook(book.getTitle()).equals(book)) {
            bookDao.save(book);
        }
        dbItem.addItem(findBook(book.getTitle()).getTitleId());
    }

    public void deleteBook(final int id) {
        bookDao.deleteById((id));
    }

    public Book findBook(final String bookTitle) {
        List<Book> bookList = bookDao.findAll();
        for (Book findedBook : bookList) {
            if (findedBook.getTitle().equalsIgnoreCase(bookTitle)) {
                return findedBook;
            }
        }
        return new Book();
    }

    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }


}
