package com.library.service;

import com.library.controller.DatabaseErrorException;
import com.library.domain.dao.EntryDao;
import com.library.domain.dao.ItemDao;
import com.library.domain.dao.ReaderDao;
import com.library.domain.entities.Entry;
import com.library.domain.entities.Item;
import com.library.domain.entities.Reader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static com.library.domain.entities.Item.AVAIL;
import static com.library.domain.entities.Item.NOTAVAIL;

@Service
@RequiredArgsConstructor
public class RentService {
    private final ItemDao itemDao;
    private final ReaderDao readerDao;
    private final EntryDao entryDao;

    public Item borrowBook(final int bookId, final int readerId) throws DatabaseErrorException {
        Reader reader = readerDao.findById(readerId).orElseThrow(DatabaseErrorException::new);
        Item item = itemDao.findById(bookId).orElseThrow(DatabaseErrorException::new);
        reader.getBorrowedBooks().add(item);
        item.setBookStatus(NOTAVAIL);
        item.setReader(reader);
        Entry entry = new Entry(bookId, readerId);
        entryDao.save(entry);
        readerDao.save(reader);
        return itemDao.save(item);

    }

    public Item returnBook(final int bookId) throws DatabaseErrorException {
        Entry entry = entryDao.findByBookId(bookId).orElseThrow(DatabaseErrorException::new);
        Reader reader = readerDao.findById(entry.getReaderId()).orElseThrow(DatabaseErrorException::new);
        Item item = itemDao.findById(entry.getBookId()).orElseThrow(DatabaseErrorException::new);
        reader.getBorrowedBooks().remove(item);
        item.setBookStatus(AVAIL);
        item.setReader(null);
        entry.setDateOfReturn(LocalDate.now());
        entryDao.save(entry);
        readerDao.save(reader);
        return itemDao.save(item);
    }
}
