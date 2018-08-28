package com.library.service;

import com.library.controller.NotFoundException;
import com.library.domain.entities.Book;
import com.library.domain.entities.Entry;
import com.library.domain.entities.Item;
import com.library.domain.entities.Reader;
import com.library.domain.dao.ItemDao;
import com.library.domain.dao.BookDao;
import com.library.domain.dao.EntryDao;
import com.library.domain.dao.ReaderDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static com.library.domain.entities.Item.AVAIL;
import static com.library.domain.entities.Item.NOTAVAIL;

@Service
@RequiredArgsConstructor
public class DbService {
    private final BookDao bookDao;
    private final ItemDao itemDao;
    private final ReaderDao readerDao;
    private final EntryDao entryDao;

    public void addBook(final Book book) {
        if (!findBook(book.getTitle()).equals(book)) {
            bookDao.save(book);
        }
        addItem(findBook(book.getTitle()).getTitleId());
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

    public Reader saveReader(final Reader reader) {
        return readerDao.save(reader);
    }

    public Item borrowBook(final int bookId, final int readerId) throws NotFoundException{
        Reader reader = readerDao.findById(readerId).orElseThrow(NotFoundException::new);
        Item item = itemDao.findById(bookId).orElseThrow(NotFoundException::new);
        reader.getBorrowedBooks().add(item);
        item.setBookStatus(NOTAVAIL);
        Entry entry = new Entry(bookId, readerId);
        entryDao.save(entry);
        readerDao.save(reader);
        return itemDao.save(item);

    }

    public Item returnBook(final int bookId) throws NotFoundException{
        Entry entry = entryDao.findByBookId(bookId).orElseThrow(NotFoundException::new);
        Reader reader = readerDao.findById(entry.getReaderId()).orElseThrow(NotFoundException::new);
        Item item = itemDao.findById(entry.getBookId()).orElseThrow(NotFoundException::new);
        reader.getBorrowedBooks().remove(item);
        item.setBookStatus(AVAIL);
        entry.setDateOfReturn(LocalDate.now());
        entryDao.save(entry);
        readerDao.save(reader);
        return itemDao.save(item);
    }
}
