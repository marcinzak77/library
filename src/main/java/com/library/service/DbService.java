package com.library.service;

import com.library.controller.NotFoundException;
import com.library.domain.entities.Book;
import com.library.domain.entities.Entry;
import com.library.domain.entities.Item;
import com.library.domain.entities.Reader;
import com.library.domain.dao.ItemDao;
import com.library.domain.dao.BookDao;
import com.library.domain.dao.BookRentDao;
import com.library.domain.dao.ReaderDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.library.domain.entities.Item.AVAIL;
import static com.library.domain.entities.Item.NOTAVAIL;

@Service
@RequiredArgsConstructor
public class DbService {
    private final BookDao bookDao;
    private final ItemDao itemDao;
    private final ReaderDao readerDao;
    private final BookRentDao bookRentDao;

    public void addBook(final Book book) {
        bookDao.save(book);
        addItem(book.getTitleId());
    }

    public void deleteBook(final int id) {
        bookDao.deleteById((id));
    }

    public void addItem(final int titleId) {
        Item item = new Item(titleId, AVAIL);
        itemDao.save(item);
    }

    public void deleteItem(final int bookId) {
        itemDao.deleteById(bookId);
    }

    public Reader saveReader(final Reader reader) {
        return readerDao.save(reader);
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

    public Item borrowBook(final Entry entry) throws NotFoundException{
        Reader reader = readerDao.findById(entry.getReaderId()).orElseThrow(NotFoundException::new);
        Item item = itemDao.findById(entry.getBookId()).orElseThrow(NotFoundException::new);
        reader.getBorrowedBooks().add(item);
        item.setBookStatus(NOTAVAIL);
        readerDao.save(reader);
        return itemDao.save(item);

    }

    public Item returnBook(final Entry entry) throws NotFoundException{
        Reader reader = readerDao.findById(entry.getReaderId()).orElseThrow(NotFoundException::new);
        Item item = itemDao.findById(entry.getBookId()).orElseThrow(NotFoundException::new);
        reader.getBorrowedBooks().remove(item);
        item.setBookStatus(AVAIL);
        readerDao.save(reader);
        return itemDao.save(item);
    }
}
